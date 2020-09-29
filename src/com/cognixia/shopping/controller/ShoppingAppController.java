package com.cognixia.shopping.controller;

import com.cognixia.shopping.model.Invoice;
import com.cognixia.shopping.model.Item;
import com.cognixia.shopping.repository.FakeDatabase;
import com.cognixia.shopping.utility.InputValidationUtil;

public class ShoppingAppController {
	
	private static boolean isLoggedIn = false;
	private static int loggedInUserId = -1;
	
	public static boolean checkLoggedIn() {
		return isLoggedIn;
	}
	
	public static int checkLoggedUserId() {
		return loggedInUserId;
	}
	
	public static void register(String email, String password, String confirmPass) {
		if(InputValidationUtil.validPassword(password) && password.equals(confirmPass)) {
			FakeDatabase.addNewUser(email, password);
			System.out.println("User registered");
		} else {
			System.out.println("Failed register");
		}
	}
	
	public static void login(String email, String password) {
		if(InputValidationUtil.validLogin(email, password)) {
			isLoggedIn = true;
			loggedInUserId = FakeDatabase.getUserIndex(email, password);
			System.out.println("Logging in");
		} else {
			System.out.println("Failed log in");
		}
	}
	
	public static void logout() {
		isLoggedIn = false;
		loggedInUserId = -1;
		System.out.println("Logging out");
	}
	
	// Item Purchase part
	// User sees list of items
	// User is prompted for item index
	// User is prompted for invoice number
	// If new number, create new invoice with that number and add item to it
	// If current number, add item to invoice
	// Return to home page
	public static void purchase(int itemIndex, int invoiceNum) {
		boolean invoiceExists = false;
		Item purchasedItem = FakeDatabase.getItem(itemIndex);
		Invoice orderInvoice = new Invoice();
		
		for(Invoice iv: FakeDatabase.invoiceList) {
			if(iv.getInvoiceNum() == invoiceNum) {
				invoiceExists = true;
				orderInvoice = iv;
				break;
			}
		}
		
		orderInvoice.addItem(purchasedItem);
		
		if(!invoiceExists) {
			orderInvoice.setInvoiceNum(invoiceNum);
			FakeDatabase.addNewInvoice(orderInvoice);
		} else {
			FakeDatabase.updateInvoice(orderInvoice);
		}
		
	}
	
	// Invoice Replace part
	// User selects Replace Item
	// User is prompted for invoice number
	// User is prompted for item index in invoice
	// Some kind of date check for 15 days?
	// Return item ?????
	
	public static void replace(int invoiceNum, int itemIndex) {
		
	}

}
