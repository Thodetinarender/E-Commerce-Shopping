package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.CartItem;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.model.User;

import java.util.List;

public interface CartItemService {

    void addCartItem(User user, Product product, int quantity);

    List<CartItem> getCartItemsByUser(User user);

    

	void updateCartItemQuantity(Long cartItemId, int quantity);

	void deleteCartItem(Long cartItemId);

   
}
