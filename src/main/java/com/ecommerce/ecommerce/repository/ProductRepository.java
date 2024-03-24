package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query method to find products by name
   // List<Product> findByName(String name);
    
    //List<Product> products = productRepository.findByName("Product Name");

}

