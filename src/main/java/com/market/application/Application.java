package com.market.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@EntityScan("com.market.entities")*/
/*@EnableJpaRepositories("com.market.application.repositories")*/
/*@ComponentScan({"com.market.application.repositories.UserRepository"})*/
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}