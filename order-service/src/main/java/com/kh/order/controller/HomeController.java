package com.kh.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String greeting() {
        try {
            String response = restTemplate.getForObject("https://localhost.sbilhbank.com.kh:9002/product", String.class);
            return "Hello from order service!" + "\n" + response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}