package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.ecommerce.UserService.UserService;
import com.ecommerce.ecommerce.model.CartItem;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.service.CartItemService;
import com.ecommerce.ecommerce.service.ProductService;

@Controller
@RequestMapping
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

//    @PostMapping("/cart")
//    public String showCart(Model model, @AuthenticationPrincipal UserDetails userDetails) {
//        User user = userService.findByEmail(userDetails.getUsername());
//        Cart cart = cartService.getCartByUser(user);
//        model.addAttribute("cart", cart);
//        return "cart";
//    }
    
    
    @PostMapping("/cart/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
        } else {
            // Handle the case where the product is not found
            model.addAttribute("error", "Product not found");
        }
        return "cart";
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable("id") long productId, @RequestParam("quantity") int quantity, @AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByEmail(userDetails.getUsername());
        Product product = productService.findById(productId);

        if (user != null && product != null) {
            cartItemService.addCartItem(user, product, quantity);
            model.addAttribute("message", "Product added to cart successfully!");
        } else {
            model.addAttribute("error", "Failed to add product to cart.");
        }

        return "redirect:/view";
    }

    @GetMapping("/cart")
    public String cartHome() {
    	return "redirect:/view";
    }
    
    @GetMapping("/view")
    public String viewCart(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByEmail(userDetails.getUsername());
        List<CartItem> cartItems = cartItemService.getCartItemsByUser(user);
        model.addAttribute("cartItems", cartItems);
        return "cartdetails";
    }

    // Update cart item quantity
    @PostMapping("/update/{id}")
    public String updateCartItem(@PathVariable("id") Long cartItemId, @RequestParam("quantity") int quantity) {
        cartItemService.updateCartItemQuantity(cartItemId, quantity);
        return "redirect:/view";
    }

 // Delete cart item
    @PostMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable("id") Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
        return "redirect:/view";
    }
   
}
