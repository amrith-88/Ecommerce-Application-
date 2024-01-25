package com.eca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="ecommerce")
public class Ecommerce {
	@Id
	@GeneratedValue
	private int productId;
	private String name;
	private String description;
	private double price;
	private int quantityAvailable;
	private double discountRate;
    private double taxRate;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public Ecommerce(int productId, String name, String description, int price, int quantityAvailable,
			double discountRate, double taxRate) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
		this.discountRate = discountRate;
		this.taxRate = taxRate;
	}

	public Ecommerce() {
		super();
	}



}
