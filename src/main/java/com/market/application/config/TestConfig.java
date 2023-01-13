package com.market.application.config;

import java.util.Arrays;

import com.market.application.dto.ProductDTO;
import com.market.application.entities.Category;
import com.market.application.entities.Product;
import com.market.application.repositories.CategoryRepository;
import com.market.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.market.application.repositories.UserRepository;
import com.market.application.entities.User;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		//TODO Setar dependencias nas entidades
		//TODO Testar crud com as dependencias
		//TODO Inserir tabelas de dependência
		//TODO Commitar método findByName no service
		//TODO Implementar findByname no resource
		
		User u1 = new User(1, "Marcos", "marcos@hotmail.com");
		User u2 = new User(2, "Beatriz", "beatriz@hotmail.com");

		Product product = new Product(1,"Banana","Fruta", 2.0);
		Product product2 = new Product(2, "Maçã", "Fruta", 2.0);
		Product product3 = new Product(3, "Violão", "Instrumento", 300.0);

		Category category = new Category(1, "Frutas", "Alimento");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		productRepository.saveAll(Arrays.asList(product, product2, product3));
		categoryRepository.save(category);
	}
}