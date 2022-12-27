package com.market.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}