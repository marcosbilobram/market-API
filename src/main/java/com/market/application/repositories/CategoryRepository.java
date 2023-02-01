package com.market.application.repositories;

import com.market.application.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import com.market.application.entities.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


}
