package com.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query method to find products by name
   // List<Product> findByName(String name);
    
    //List<Product> products = productRepository.findByName("Product Name");
	
	
//	@Procedure(procedureName = "product_search")
//	List<Product> dbSearchProducts(@Param("search_text") String searchText);


    @Procedure(name = "SearchProduct.searchProducts")
    List<Product> products_search(String searchText);
}

