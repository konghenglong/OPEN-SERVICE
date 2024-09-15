package com.kh.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.product.base-url}")
    private String productBaseUrl;

    @Value("${api.product.get-product}")
    private String getProductUrl;

    @GetMapping
    public String greeting() {
        try {
            String response = restTemplate.getForObject(productBaseUrl + getProductUrl, String.class);
            return "Hello from order service!" + "\n" + response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}