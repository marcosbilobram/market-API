package com.market.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entities.User;
	
public interface UserRepository extends JpaRepository<User, Integer> {

}
