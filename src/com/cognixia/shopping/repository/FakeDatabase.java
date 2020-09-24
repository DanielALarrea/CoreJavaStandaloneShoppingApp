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
	
	// Add an item to the "database"
	public static void addNewItem(String name, String code, float price) {
		itemList.add(new Item(name, code, price));
	}
	
	// Add an invoice to the "database"
	public static void addNewInvoice(int invoiceNum) {
		invoiceList.add(new Invoice(invoiceNum));
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
