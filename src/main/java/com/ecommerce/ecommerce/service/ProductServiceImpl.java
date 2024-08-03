package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.NewArrivals;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repository.NewArrivalsRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;

	
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    

    @Override
    public void addProduct(Product product) {
         this.productRepository.save(product);
    }

   
	
	//......................................
//new Table creation New Arrivals 
	@Autowired
	private NewArrivalsRepository newArrivalsRepository;
  

	@Override
	public List<NewArrivals> getNewArrivals() {
		
		return newArrivalsRepository.findAll();
	}
	
	@Override
    public void addNewArrivals(NewArrivals newArrivals) {
         this.newArrivalsRepository.save(newArrivals);
    }
	
	@Override
	public NewArrivals getNewArrivalsProductById(long id) {
		Optional<NewArrivals>optional = newArrivalsRepository.findById(id);
		NewArrivals newArrivals =null;
		if(optional.isPresent()) {
			newArrivals = optional.get();
		}
		else {
			throw new RuntimeException("New Arrivals Product not found id ::"+  id);
		}
		return newArrivals;
	}
	
	public void deleteNewArrivalById(long id) {
		this.newArrivalsRepository.deleteById(id);
	}
	
	// ....................
	//Update Implementation
	@Override
	public Product getProductById(long id) {
		Optional<Product> optinal =productRepository.findById(id);
		Product product=null;
		
		if(optinal.isPresent()) {
			product =optinal.get();
			
		}
		else {
			throw new RuntimeException("Product not found id ::"+  id);
		}
		return product;
		
	}
	
	public void deleteProductById(long id) {
		this.productRepository.deleteById(id);
	}
	
	 @Override
	    public Product findById(long productId) {
	        return productRepository.findById(productId).orElse(null);
	    }
	
	
}
