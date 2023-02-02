package com.market.application.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_mkt_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private Double pricePerUnit;
	private Integer quantity = 0;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "tb_mkt_prod_categ",
			joinColumns =
			@JoinColumn(
					name = "prod_id",
					referencedColumnName = "id"
			),
			inverseJoinColumns = @JoinColumn(
					name = "categ_id",
					referencedColumnName = "id"
			)

	)
	@JsonIgnore
	private List<Category> categories = new ArrayList<>();
	
	public Product() {
	}

	public Product(Integer id, String name, String description, Double pricePerUnit, Integer quantity, List<Category> categories) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
		this.categories = categories;
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
