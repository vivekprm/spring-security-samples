package com.multiuigateway.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class MultiuiGatewayResourceApplication extends WebSecurityConfigurerAdapter {
	private List<Change> changes = new ArrayList<>();

	@RequestMapping(value = "/api/changes", method = RequestMethod.GET)
	public List<Change> changes() {
		return changes;
	}

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

class Change {
	private Date timestamp = new Date();
	private String user;
	private String message;

	Change() {
	}

	public Change(String user, String message) {
		this.user = user;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}
}