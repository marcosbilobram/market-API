package com.market.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.application.entities.Category;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
