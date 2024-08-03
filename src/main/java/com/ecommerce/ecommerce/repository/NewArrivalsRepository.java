package com.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.model.NewArrivals;

@Repository
public interface NewArrivalsRepository extends JpaRepository<NewArrivals, Long> {

	 @Procedure(name = "SearchNewArrival.searchProducts")
	    List<NewArrivals> new_arrivals_search(String searchText);
	
}
