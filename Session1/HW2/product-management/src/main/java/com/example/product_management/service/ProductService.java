package com.example.product_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product_management.model.Product;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("1", "Product 1", 10.0));
        products.add(new Product("2", "Product 2", 20.0));
        products.add(new Product("3", "Product 3", 30.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
