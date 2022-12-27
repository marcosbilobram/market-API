package com.market.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.market.application.repositories.UserRepository;


@Configuration
@Profile("test")
public class TestConfig {

	@SuppressWarnings("unused")
	@Autowired
	private UserRepository userRepository;

}
