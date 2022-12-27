package com.market.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
