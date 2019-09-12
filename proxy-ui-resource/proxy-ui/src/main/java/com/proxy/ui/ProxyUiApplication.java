package com.proxy.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ProxyUiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyUiApplication.class, args);
    }
}