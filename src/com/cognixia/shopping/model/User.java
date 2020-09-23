package com.cognixia.shopping.model;

public class User {
	
	private String email;
	private String password;
	private Invoice invoice;
//	private List<Item> invoice;
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password, Invoice invoice) {
		super();
		this.email = email;
		this.password = password;
		this.invoice = invoice;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	

}
