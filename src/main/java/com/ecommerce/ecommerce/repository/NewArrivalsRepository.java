package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.model.NewArrivals;

@Repository
public interface NewArrivalsRepository extends JpaRepository<NewArrivals, Long> {


}
