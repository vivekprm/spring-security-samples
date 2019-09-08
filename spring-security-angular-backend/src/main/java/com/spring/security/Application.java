package com.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    @RequestMapping("/greeting")
    public Greeting greeting(){
        return new Greeting("Hello Vegas!");
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
