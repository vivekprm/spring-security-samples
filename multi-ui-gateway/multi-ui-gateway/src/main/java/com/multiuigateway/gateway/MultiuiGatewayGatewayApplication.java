package com.multiuigateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableZuulProxy
public class MultiuiGatewayGatewayApplication extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(MultiuiGatewayGatewayApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .httpBasic().and()
                .logout().and()
                .authorizeRequests()
                .antMatchers("/index.html", "/").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // @formatter:on
    }
}
