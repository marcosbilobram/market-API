package com.market.application.dto;

import com.market.application.entities.Category;
import com.market.application.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private Integer id;
    private String name;
    private String description;

    List<Product> products = new ArrayList<>();
    public CategoryDTO(){
    }

    public CategoryDTO(Category category){
        id = category.getId();
        name = category.getName();
        description = category.getDescription();
        products = category.getProducts();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
