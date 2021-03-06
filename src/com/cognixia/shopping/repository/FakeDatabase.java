package com.cognixia.shopping.repository;

import java.time.LocalDate;
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
	public static void addNewUser(String name, String email, String password) {
		userList.add(new User(name, email, password));
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
//		addNewUser("John", "email@gmail.com", "P@ssw0rd");
		addNewUser("name", "1", "2");
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
		invoice.setUserId(0);
		invoice.setTimeOfCreation(LocalDate.now());
		addNewInvoice(invoice);
	}
	
	// Get user by their email and password
	public static User getUser(String email, String password) {
		for(User u: userList) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return u;
			}
		}
		
		return new User("NAME NOT FOUND", "EMAIL NOT FOUND", "PASSWORD NOT FOUND");
	}
	
	// Get user by their index in the database
	public static User getUser(int userIndex) {
		for(int i = 0; i < userList.size(); i++) {
			if(i == userIndex) {
				return userList.get(userIndex);
			}
		}
		
		return new User("NAME NOT FOUND", "EMAIL NOT FOUND", "PASSWORD NOT FOUND");
	}
	
	// Get user's index by their email and password
	public static int getUserIndex(String email, String password) {
		for(int i = 0; i < userList.size(); i++) {
			User u = userList.get(i);
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return i;
			}
		}
		
		return -1;
	}
	
	// Get user's name by their index
	public static String getUserNameByIndex(int userIndex) {
		return getUser(userIndex).getName();
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
	
	// Get item by their index
	public static Item getItem(int index) {
		for(int i = 0; i < itemList.size(); i++) {
			if((i+1) == index) {
				return itemList.get(i);
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
	
	// Update user in database
	public static void updateUser(int userIndex, User user) {
		User u = userList.get(userIndex);
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setInvoiceList(user.getInvoiceList());
	}
	
	// Update invoice in database
	public static void updateInvoice(Invoice invoice) {
		for(Invoice iv: invoiceList) {
			if(iv.getInvoiceNum() == invoice.getInvoiceNum()) {
				iv = invoice;
			}
		}
		
	}
}
