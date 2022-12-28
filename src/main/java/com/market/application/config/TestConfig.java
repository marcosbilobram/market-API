package com.market.application.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.market.application.repositories.UserRepository;
import com.market.entities.User;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	/*@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;*/

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(1, "Marcos", "marcos@hotmail.com");
		User u2 = new User(2, "Beatriz", "beatriz@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
