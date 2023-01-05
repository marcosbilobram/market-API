package com.market.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.application.repositories.UserRepository;
import com.market.application.entities.User;

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
	
	public void delete(Integer id) {
		findById(id);
		userRepo.deleteById(id);
	}
	
	public User insert(User user) {
		return userRepo.save(user);
	}
	
	
	public User update(User user) {
		User usr = findById(user.getId());
		dataUpdate(usr, user);
		return userRepo.save(usr);
	}
	
	public void dataUpdate(User userToAtt, User user) {
		userToAtt.setName(user.getName());
		userToAtt.setEmail(user.getEmail());
	}
	
}
