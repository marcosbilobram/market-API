package com.market.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.application.repositories.UserRepository;
import com.market.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> user = userRepo.findById(id);
		return user.get();
	}
	
	
	
	
}
