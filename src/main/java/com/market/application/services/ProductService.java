package com.market.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.market.application.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.application.repositories.ProductRepository;
import com.market.application.entities.Product;
import com.market.application.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> prd = productRepo.findById(id);
		return prd.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public void delete(Integer id) {
		productRepo.deleteById(id);
	}
	
	public Product insert(Product product) {
		return productRepo.save(product);
	}
	
	public Product update(Product product) {
		Product prod = findById(product.getId());
		dataUpdate(prod, product);
		return productRepo.save(prod);
	}
	
	public void dataUpdate(Product prodToAtt, Product product) {
		prodToAtt.setName(product.getName());
		prodToAtt.setPrice(product.getPrice());
		prodToAtt.setDescription(product.getDescription());
	}

	public Product fromDTO(ProductDTO productDTO){
		return new Product(productDTO.getId(), productDTO.getName(), productDTO.getDescription(),productDTO.getPrice());
	}

	public List<Product> findByName(String name){
		String parseNM = name.toLowerCase();
		List<Product> productIM = productRepo.findAll();
		List<Product> productResp = new ArrayList();
		try {
			for (Product prd: productIM) {
				if ((prd.getName().toLowerCase()).contains(parseNM)){
					productResp.add(prd);
				}
			}
		}
		catch (ObjectNotFoundException e){
			e.getMessage();
		}
		if (productResp.isEmpty()){
			throw new ObjectNotFoundException("Produto não encontrado");
		}
		return productResp;
	}
	
}
