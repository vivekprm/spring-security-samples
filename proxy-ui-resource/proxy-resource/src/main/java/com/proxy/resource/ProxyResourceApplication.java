package com.proxy.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProxyResourceApplication extends WebSecurityConfigurerAdapter {

	@RequestMapping("/api/greeting")
	public Greeting greeting() {
		return new Greeting("Hello proxy backend");
	}

	public static void main(String[] args) {
		SpringApplication.run(ProxyResourceApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable();
		http.authorizeRequests().anyRequest().authenticated();
	}

}
