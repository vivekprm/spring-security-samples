package com.multiuigateway.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MultiuiGatewayResourceApplication extends WebSecurityConfigurerAdapter {

	@RequestMapping("/api/greeting")
	public Greeting greeting() {
		return new Greeting("Hello proxy backend");
	}

	public static void main(String[] args) {
		SpringApplication.run(MultiuiGatewayResourceApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// We need this to prevent the browser from popping up a dialog on a 401
		http.httpBasic().disable().csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
}
