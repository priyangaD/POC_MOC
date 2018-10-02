package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@Column(name = "item_code")
	private String code;
	
	@Column(name = "item_name")
	private String name;
	
	@Column(name = "item_category")
	private String category;
	
	@Column(name = "item_price")	
	private Double price;
	
	@Column(name = "item_tax")
	private Double tax;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	
	
}