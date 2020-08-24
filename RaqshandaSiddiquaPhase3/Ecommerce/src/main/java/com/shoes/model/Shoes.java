package com.shoes.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Shoes {
	@Id
	private int productId;
	@Override
	public String toString() {
		return "Shoes [productId=" + productId + ", brand=" + brand + ", color=" + color + ", size=" + size + ", price="
				+ price + "]";
	}
	public Shoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shoes(int productId, String brand, String color, int size, int price) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String brand;
	private String color;
	private int size;
	private int price;
}
