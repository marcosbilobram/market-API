package com.market.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.entities.Product;
import com.market.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService product;
	
	@GetMapping
	public  ResponseEntity<List<Product>> findAll(){
		List<Product> prod = product.findAll();
		return ResponseEntity.ok().body(prod);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product prod = product.findById(id);
		return ResponseEntity.ok().body(prod);
	}
	
	
}
