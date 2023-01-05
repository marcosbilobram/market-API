package com.market.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.application.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
