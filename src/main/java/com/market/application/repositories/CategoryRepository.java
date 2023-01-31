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

    @Query(value = "INSERT INTO tb_mkt_prod_categ VALUES(?1,?2)",
    nativeQuery = true)
    void AddProductsByIdIntoAssociateTable( int productId, int categoryId);

    //void AddProducts(String name,List<Product> list);
}
