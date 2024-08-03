package com.ecommerce.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SearchNewArrival {
	
	    @Id
	    private Long id;
	    private String description;
	    private String image;
	    private String product_name;
	    private double price;

}
