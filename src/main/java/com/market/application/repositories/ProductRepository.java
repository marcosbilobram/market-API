package com.market.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.application.entities.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    List<Product> findByName(String name);

    //TODO findProductsByCategory

}
