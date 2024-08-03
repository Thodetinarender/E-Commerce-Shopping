package com.ecommerce.ecommerce.controller; // Corrected package name to follow conventions

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.ecommerce.model.NewArrivals;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.service.ProductService;


@Controller
public class HomeController {

	@Autowired
	UserDetailsService userDetailsService;


	@Autowired
	private  ProductService productService;
	 	  
	//home page Controller
	
	@GetMapping({"/", "/index"})
	public String showProductPage(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("NewArrivals", productService.getNewArrivals());
		return "index"; // This maps to product.html template
	}
	
	@GetMapping("/adminShowProducts")
	public String adminShowProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("NewArrivals", productService.getNewArrivals());
		return "adminShowProducts"; // This maps to product.html template
	}
	
	
	//Shop page Controller
		@GetMapping("/shop")
		public String showShopPage(Model model) {
			model.addAttribute("products", productService.getAllProducts());
			model.addAttribute("NewArrivals", productService.getNewArrivals());
			return "shop"; // This maps to product.html template
		}

	@GetMapping("/blog")
	public String blog() {
		return "blog"; // Returns blog.html
	}

	@GetMapping("/about")
	public String about() {
		return "about"; // Returns about.html
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact"; // Returns contact.html
	}
	
	@GetMapping("/account")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return  "account"; // Returns contact.html 
	}
	
	

	@GetMapping("/sproduct")
	public String sproduct() {
		return "sproduct"; // Returns sproduct.html
	}
	

	//...............................................//
	
	/// New Arrivals Table CURD Functions
	@GetMapping("/addNewArrivals")
	public String shownewProductFroms(Model model) {
			NewArrivals newArrivals =new NewArrivals();
			model.addAttribute("newArrivals", newArrivals);
			return "newArrivalsAddProduct";
		}
	@PostMapping("/SaveNewArrivals")
	public String SaveNewArrival(@ModelAttribute("newArrivals")NewArrivals newArrivals) {
		productService.addNewArrivals(newArrivals);
		return "redirect:/adminShowProducts";
	}
	
	@GetMapping("/updateNewArrivals/{id}")
	public String updateNewArrivals(@PathVariable(value = "id") long id, Model model) {
		NewArrivals newArrivals = productService.getNewArrivalsProductById(id);
		model.addAttribute("newArrivals", newArrivals);
		return "updateNewArrivals";
	}
	
	@GetMapping("/deleteNewArrivals/{id}")
		public String deleteNewArrivals(@PathVariable(value = "id")long id) {
			//call delete product method
			this.productService.deleteNewArrivalById(id);
			return "redirect:/adminShowProducts";
			
		}

	//...............................................//
	/// Product Table CURD Functions
	@GetMapping("/addProduct")
	public String shownewProductFrom(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "AdminAddProducts";
	}

	@PostMapping("/ProductSave")
	public String ProductSave(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/adminShowProducts";
	}
	
		// Update Function
		@GetMapping("/showFormForUpadte/{id}")
		public String showFormForUpadte(@PathVariable(value = "id") long id, Model model) {
			Product product = productService.getProductById(id);
			model.addAttribute("product", product);
			return "update_product";
		}
		
			// delete Function
		
		@GetMapping("/deleteEmployee/{id}")
		public String deleteProduct(@PathVariable (value = "id") long id) {
			//call delete product method
			this.productService.deleteProductById(id);
			return "redirect:/adminShowProducts";
		}


	//.............................................../

	
	

}
