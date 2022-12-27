package com.market.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.market.application.repositories.CategoryRepository;
import com.market.application.repositories.ProductRepository;
import com.market.application.repositories.UserRepository;


@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
}
