package com.market.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.application.entities.Category;
import com.market.application.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService category;
	
	@GetMapping
	public  ResponseEntity<List<Category>> findAll(){
		List<Category> ctg = category.findAll();
		return ResponseEntity.ok().body(ctg);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id){
		Category ctg = category.findById(id);
		return ResponseEntity.ok().body(ctg);
	}
	
}
