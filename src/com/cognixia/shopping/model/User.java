package com.cognixia.shopping.model;

import java.util.List;

public class User {
	
	private String email;
	private String password;
	private List<Invoice> invoiceList;
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password, List<Invoice> invoiceList) {
		super();
		this.email = email;
		this.password = password;
		this.invoiceList = invoiceList;
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
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public void addInvoice(Invoice invoice) {
		this.invoiceList.add(invoice);
	}

}
