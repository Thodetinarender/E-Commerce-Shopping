package com.ecommerce.ecommerce;

import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Configuration
	public class ModelMapperConfig {

	    @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
	}

}
