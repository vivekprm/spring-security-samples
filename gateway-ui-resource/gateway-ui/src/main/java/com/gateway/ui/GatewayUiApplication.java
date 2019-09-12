package com.gateway.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Map;

@SpringBootApplication
@RestController
public class GatewayUiApplication {
    @Autowired
    private HttpSession session;

    @RequestMapping("/greeting")
    public Map<String, Object> greeting() {
        return restTemplate().exchange("http://localhost:9000", HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Map<String, Object>>() {

                }).getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayUiApplication.class, args);
    }

    private RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, context) -> {
            request.getHeaders().add("Cookie", "SESSION=" + session.getId());
            return context.execute(request, body);
        });
        return restTemplate;
    }
}
