package com.ecommerce.ecommerce.service;

import java.util.List;

import com.ecommerce.ecommerce.model.NewArrivals;
import com.ecommerce.ecommerce.model.Product;

public interface ProductService {

    List<Product> getAllProducts();
    List<NewArrivals> getNewArrivals();
 
    void addNewArrivals(NewArrivals newArrivals);
    
    NewArrivals getNewArrivalsProductById(long id);
   
    void deleteNewArrivalById(long id); 
    
    void addProduct(Product product);
    
    Product getProductById(long id);
    
    void deleteProductById(long id);
    
    Product findById(long productId);

}
