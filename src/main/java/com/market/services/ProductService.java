package com.market.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.application.repositories.ProductRepository;
import com.market.entities.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prodctRepo;
	
	public List<Product> findAll(){
		return prodctRepo.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> prd = prodctRepo.findById(id);
		return prd.get();
	}
	
	public void delete(Integer id) {
		findById(id);
		prodctRepo.deleteById(id);
	}
}
