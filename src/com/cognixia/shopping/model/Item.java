package com.cognixia.shopping.model;

public class Item {
	
	private String name;
	private String code;
	private float price;
	
	public Item(String name, String code, float price) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", code=" + code + ", price=" + price + "]";
	}

}
