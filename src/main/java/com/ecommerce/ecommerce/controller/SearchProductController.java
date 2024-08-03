package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.ecommerce.model.NewArrivals;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repository.NewArrivalsRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;

@RestController
public class SearchProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	NewArrivalsRepository newArrivalsRepository;
	
	 @Transactional
	    @PostMapping("/search")
	    public ModelAndView searchProductsHtml(@RequestParam("query") String searchText, Model model) {
	        List<Product> productList = productRepository.products_search(searchText);
	        List<NewArrivals> newArrivalList = newArrivalsRepository.new_arrivals_search(searchText);
	        
	        model.addAttribute("productList", productList);
	        model.addAttribute("newArrivalList",newArrivalList);
	        return new ModelAndView("searchProducts"); // Assuming "searchResults" is the name of your HTML template
	    }
	
}
