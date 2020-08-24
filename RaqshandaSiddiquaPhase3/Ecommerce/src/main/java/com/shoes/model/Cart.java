package com.shoes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class Cart {
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartName=" + cartName + ", qty=" + qty + ", shoes=" + shoes + "]";
	}

	@Id
	private int cartId;
	public int getCartId() {
		return cartId;
	}

	public Cart(int cartId, String cartName, int qty, List<Shoes> shoes) {
		super();
		this.cartId = cartId;
		this.cartName = cartName;
		this.qty = qty;
		this.shoes = shoes;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public List<Shoes> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoes> shoes) {
		this.shoes = shoes;
	}

	private String cartName;
	private int qty;  //Quantity
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable(name = "cart_shoes",
	joinColumns = @JoinColumn(name="cartId"),
	inverseJoinColumns = @JoinColumn(name="shoesId"))
	private List<Shoes> shoes;
	

}
