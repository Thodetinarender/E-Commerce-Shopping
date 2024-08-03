package com.ecommerce.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewArrivalsDTO {

	private Long id;
	private String name;
	private String description;
	private double price;
	private String image;

}
