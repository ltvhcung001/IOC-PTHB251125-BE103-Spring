package com.example.product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;


@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public String getMethodName(@RequestParam String param) {
        return productService.getAllProducts().toString();
    }

    @PostMapping("/api/products")
    public String createProduct(@RequestBody Product product) {
        boolean isCreated = productService.createProduct(product);
        if (isCreated) {
            return "Product created successfully";
        } else {
            return "Failed to create product";
        }
    }

    @PutMapping("/api/products/{id}")
    public String updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.getAllProducts().removeIf(p -> p.getId().equals(id));
        productService.createProduct(product);
        return "Product updated successfully";
    }

    @DeleteMapping("/api/products/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.getAllProducts().removeIf(p -> p.getId().equals(id));
        return "Product deleted successfully";
    }
}
