package com.nix.afinal;

import java.util.Date;

public class Product {
	private String productID;
	private String Name;
	private Float Price;
	private String Image;
	private Date date;
	
	public Product() {
	}
	
	public Product(String productID, String name, Float price, String image,
			Date date) {
		this.productID = productID;
		Name = name;
		Price = price;
		Image = image;
		this.date = date;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
