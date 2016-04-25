package org.cart.item;

import java.math.BigDecimal;

public class Item {

	String name;
	int qty;
	BigDecimal price;
	
	public Item() {
		super();
	}

	public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
