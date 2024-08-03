package com.ecommerce.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Data;

@Entity
@Data
public class SearchProduct {
	
	@Id
	private Long id;
	
	
	private String product_name;
	
	private String description;

	private double price;
	
	private String image;


}
