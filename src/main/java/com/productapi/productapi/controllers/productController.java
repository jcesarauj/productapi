package com.productapi.productapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {

    @GetMapping(value = "/product")
    public String Hello() {
        return "olá mundo";
    }
}
