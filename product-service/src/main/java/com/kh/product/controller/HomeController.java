package com.kh.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class HomeController {

    @GetMapping
    public String greeting() {
        return "Hello from product service";
    }

}