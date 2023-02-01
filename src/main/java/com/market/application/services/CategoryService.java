package com.market.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.market.application.dto.CategoryDTO;
import com.market.application.entities.Product;
import com.market.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.application.repositories.CategoryRepository;
import com.market.application.entities.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categRepo;

	@Autowired
	private ProductRepository prodRepo;

	public List<Category> findAll(){
		return categRepo.findAll();
	}

	public Category findById(Integer id) {
		Optional<Category> ctg = categRepo.findById(id);
		return ctg.get();
	}

	public void delete(Integer id) {
		categRepo.deleteById(id);
	}

	public Category insert(Category category) {
		return categRepo.save(category);
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

	public Category fromDTO(CategoryDTO categoryDTO){
		return new Category(categoryDTO.getId(), categoryDTO.getName(), categoryDTO.getDescription());
	}

	public void populateRelationAttributesWithNStoredItens(Integer categoryId, List<Product> products){
		Category ctg = findById(categoryId);
		for(Product p : products){
			prodRepo.save(p);
			ctg.getProducts().add(p);
			p.getCategories().add(ctg);
			prodRepo.save(p);
			categRepo.save(ctg);
			//categRepo.AddProductsByIdIntoAssociateTable(p.getId(), ctg.getId());
		}



	}

	public void populateRelationAttributesWithStoredItens(Integer categoryId, List<Integer> productsId){
		Category ctg = findById(categoryId);
		/*List<Product> prods;
		for(Integer i : productsId){

			prods.add(prod);
		}*/
		for(Integer i : productsId){
			Product p = prodRepo.findById(i).get();
			ctg.getProducts().add(p);
			p.getCategories().add(ctg);
			prodRepo.save(p);
			categRepo.save(ctg);
			//categRepo.AddProductsByIdIntoAssociateTable(p.getId(), ctg.getId());
		}

	}

	public List<Product> findProductsById(Integer categoryId){
		Category ctg = findById(categoryId);
		return ctg.getProducts();
	}
}
