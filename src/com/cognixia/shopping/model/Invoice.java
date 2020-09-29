package com.cognixia.shopping.model;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	
	private List<Item> itemList;
	private int invoiceNum;
	
	public Invoice() {
		this.itemList = new ArrayList<Item>();
	}
	
	public Invoice(int invoiceNum) {
		super();
		this.invoiceNum = invoiceNum;
		this.itemList = new ArrayList<Item>();
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

	@Override
	public String toString() {
		return "Invoice [itemList=" + itemList + ", invoiceNum=" + invoiceNum + "]";
	}

}
