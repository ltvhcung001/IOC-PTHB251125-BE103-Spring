package com.example.product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.product_management.service.ProductService;

public class ProductController {
    @Autowired
    ProductService productService;
}
