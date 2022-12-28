package com.market.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.application.repositories.CategoryRepository;
import com.market.entities.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categRepo;
	
	public List<Category> findAll(){
		return categRepo.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> ctg = categRepo.findById(id);
		return ctg.get();
	}
	
	public void delete(Integer id) {
		findById(id);
		categRepo.deleteById(id);
	}
	
	public Category update(Category category) {
		Category ctg = findById(category.getId());
		dataUpdate(ctg, category);
		return categRepo.save(ctg);
	}
	
	public void dataUpdate(Category categToAtt, Category category) {
		categToAtt.setName(category.getName());
		categToAtt.setDescription(category.getDescription());
	}
	
}
