package com.market.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.market.entities")
/*@EnableJpaRepositories("com.market.entities.User")
@ComponentScan({"com.market.application.repositories.UserRepository"})*/
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}