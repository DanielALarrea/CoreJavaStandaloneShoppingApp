package com.cognixia.shopping.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
	
	private List<Item> itemList;
	private int invoiceNum;
	private int userId;
	private LocalDate timeOfCreation;
	
	public Invoice() {
		this.itemList = new ArrayList<Item>();
	}
	
	public Invoice(int invoiceNum) {
		super();
		this.itemList = new ArrayList<Item>();
		this.invoiceNum = invoiceNum;
	}
	
	public Invoice(List<Item> itemList, int invoiceNum) {
		super();
		this.itemList = itemList;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	
	public Item getItemFromList(int itemIndex) {
		return itemList.get(itemIndex);
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	public void addItem(Item item) {
		this.itemList.add(item);
	}
	
	public void removeItem(int itemIndex) {
		this.itemList.remove(itemIndex);
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public LocalDate getTimeOfCreation() {
		return timeOfCreation;
	}

	public void setTimeOfCreation(LocalDate timeOfCreation) {
		this.timeOfCreation = timeOfCreation;
	}

	@Override
	public String toString() {
		return "Invoice [itemList=" + itemList + ", invoiceNum=" + invoiceNum + ", userId=" + userId
				+ ", timeOfCreation=" + timeOfCreation + "]";
	}

}
