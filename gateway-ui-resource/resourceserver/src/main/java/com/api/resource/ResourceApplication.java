package com.api.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class ResourceApplication {
    @RequestMapping("/")
    public Greeting greeting(HttpServletRequest request) {
        if(request.getCookies().length > 0) {
            System.out.println(request.getCookies()[0].getName());
            System.out.println(request.getCookies()[0].getValue());
        }
        return new Greeting("Hello Backend");
    }
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}
