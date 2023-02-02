package com.market.application.dto;

import com.market.application.entities.Category;
import com.market.application.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private Double pricePerUnit;
    private Integer quantity;


    private List<Category> categories = new ArrayList<>();

    public ProductDTO(){}


    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        pricePerUnit = product.getPricePerUnit();
        quantity = product.getQuantity();
        categories = product.getCategories();
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

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
