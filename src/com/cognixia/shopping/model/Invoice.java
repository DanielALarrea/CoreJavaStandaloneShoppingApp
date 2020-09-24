package com.cognixia.shopping.model;

import java.util.List;

public class Invoice {
	
	private List<Item> itemList;
	private int invoiceNum;
	
	public Invoice() {
		
	}
	
	public Invoice(int invoiceNum) {
		super();
		this.invoiceNum = invoiceNum;
	}
	
	public Invoice(List<Item> itemList, int invoiceNum) {
		super();
		this.itemList = itemList;
		this.invoiceNum = invoiceNum;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	public void addItem(Item item) {
		this.itemList.add(item);
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

}
