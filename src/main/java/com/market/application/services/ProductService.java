package com.market.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.application.repositories.ProductRepository;
import com.market.application.entities.Product;
import com.market.application.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prodctRepo;
	
	public List<Product> findAll(){
		return prodctRepo.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> prd = prodctRepo.findById(id);
		return prd.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public void delete(Integer id) {
		prodctRepo.deleteById(id);
	}
	
	public Product insert(Product product) {
		return prodctRepo.save(product);
	}
	
	public Product update(Product product) {
		Product prod = findById(product.getId());
		dataUpdate(prod, product);
		return prodctRepo.save(prod);
	}
	
	public void dataUpdate(Product prodToAtt, Product product) {
		prodToAtt.setName(product.getName());
		prodToAtt.setPrice(product.getPrice());
		prodToAtt.setDescription(product.getDescription());
	}
	
}
