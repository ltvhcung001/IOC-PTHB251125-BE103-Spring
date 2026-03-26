package com.example.product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_management.service.ProductService;


@RestController
public class ProductController {
    @Autowired
    ProductService productService;
}
