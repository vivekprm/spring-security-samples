package com.multiuigateway.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MultiUiGatewayUiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiUiGatewayUiApplication.class, args);
    }
}