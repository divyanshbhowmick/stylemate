package com.stylemate.stylemate.controller;

import com.stylemate.stylemate.enums.CustomerType;
import com.stylemate.stylemate.model.Product;
import com.stylemate.stylemate.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/by-customer-type")
    public List<Product> getProductsByCustomerType(@RequestParam(required = false) String customerType) {
        if (customerType != null && !customerType.isEmpty()) {
            return productService.getProductsByCustomerType(CustomerType.valueOf(customerType.toUpperCase()));
        } else {
            // Handle if customerType is not provided
            return null;
        }
    }
}