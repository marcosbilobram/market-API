package com.market.application.dto;

import com.market.application.entities.Category;
import com.market.application.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;

    public ProductDTO(){}

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
