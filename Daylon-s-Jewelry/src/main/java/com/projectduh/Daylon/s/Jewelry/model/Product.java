package com.projectduh.Daylon.s.Jewelry.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	private String productname;
	private double price;
	
	public Product() {}
	
	public Integer getProductId() {
		return getProductId();
	}
	public void setProductId(Integer productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productname;
	}
	public void setProductName(String productname) {
		this.productname = productname;
	}
	public double getProductPrice() {
		return price;
	}
	public void setProductPrice(double price) {
		this.price = price;
	}

}
