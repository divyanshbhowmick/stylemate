package com.stylemate.stylemate.service;

import com.stylemate.stylemate.enums.CustomerType;
import com.stylemate.stylemate.model.Product;
import com.stylemate.stylemate.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    @Autowired
    private ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        List<Product> productList =  productRepository.findAll();
        // Log the list of products
        logger.info("Retrieved {} products", productList.size());
        for (Product product : productList) {
            logger.info("Product ID: {}, Customer Type: {}, Type: {}", product.getProductId(), product.getCustomerType(), product.getType());
            // Log other product attributes as needed
        }
        return productRepository.findAll();
    }


    @Override
    public List<Product> getProductsByCustomerType(CustomerType customerType) {
        return productRepository.findByCustomerType(customerType);
    }

}