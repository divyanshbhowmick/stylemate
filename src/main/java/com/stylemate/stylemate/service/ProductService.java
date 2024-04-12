package com.stylemate.stylemate.service;

import com.stylemate.stylemate.enums.CustomerType;
import com.stylemate.stylemate.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductsByCustomerType(CustomerType customerType);
}
