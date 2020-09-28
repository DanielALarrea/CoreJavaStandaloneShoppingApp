package com.cognixia.shopping.repository;

import java.util.ArrayList;
import java.util.List;

import com.cognixia.shopping.model.Invoice;
import com.cognixia.shopping.model.Item;
import com.cognixia.shopping.model.User;

// In-memory database representing actual database
public class FakeDatabase {
	
	public static List<User> userList = new ArrayList<User>();
	public static List<Item> itemList = new ArrayList<Item>();
	public static List<Invoice> invoiceList = new ArrayList<Invoice>();
	
	// Add a user to the "database"
	public static void addNewUser(String email, String password) {
		userList.add(new User(email, password));
	}
	
	public static void addNewUser(User user) {
		userList.add(user);
	}
	
	// Add an item to the "database"
	public static void addNewItem(String name, String code, float price) {
		itemList.add(new Item(name, code, price));
	}
	
	public static void addNewItem(Item item) {
		itemList.add(item);	
	}
	
	// Add an invoice to the "database"
	public static void addNewInvoice(int invoiceNum) {
		invoiceList.add(new Invoice(invoiceNum));
	}
	
	public static void addNewInvoice(Invoice invoice) {
		invoiceList.add(invoice);
	}
	
	// Testing all
	public static void init() {
		initUser();
		initItems();
		initInvoice();
	}
	
	// Testing user
	public static void initUser() {
		addNewUser("email@gmail.com", "P@ssw0rd");
	}

	// Items to purchase
	public static void initItems() {
		addNewItem("Jacket", "Ja1", 20);
		addNewItem("Jeans", "Je1", 10);
		addNewItem("Shirt", "Sh1", 5);
	}
	
	// Existing invoices
	public static void initInvoice() {
		Invoice invoice = new Invoice(1);
		invoice.addItem(new Item("Jacket", "Ja1", 20));
		invoice.addItem(new Item("Jeans", "Je1", 10));
		invoice.addItem(new Item("Shirt", "Sh1", 5));
		addNewInvoice(invoice);
	}
	
	// Retrieve an item from the "database"
	// Should only be used after checking the item exists
	public static Item getItem(String itemCode) {
		for(Item i: itemList) {
			if(i.getCode().equals(itemCode)) {
				return i;
			}
		}
		
		return new Item("NAME NOT FOUND", "CODE NOT FOUND", -1);
	}
	
	// Retrieve an invoice from the "database"
	// Should only be used after checking the invoice exists
	public static Invoice getInvoice(int invoiceNum) {
		for(Invoice iv: invoiceList) {
			if(iv.getInvoiceNum() == invoiceNum) {
				return iv;
			}
		}
		
		return new Invoice(-1);
	}
}
