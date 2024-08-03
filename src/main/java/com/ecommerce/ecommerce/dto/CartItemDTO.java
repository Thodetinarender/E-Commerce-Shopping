package com.ecommerce.ecommerce.dto;

import lombok.Data;

@Data
public class CartItemDTO {
	
	private long productId;
    private String productName;
    private String productImage;
    private int quantity;
    private double totalPrice;

}
