package com.cognixia.shopping.controller;

import java.time.LocalDate;

import com.cognixia.shopping.model.Invoice;
import com.cognixia.shopping.model.Item;
import com.cognixia.shopping.repository.FakeDatabase;
import com.cognixia.shopping.utility.InputValidationUtil;

public class ShoppingAppController {
	
	private static boolean isLoggedIn = false;
	private static int loggedInUserId = -1;
	private static int errorId = -1;
	
	// Get the logged in status
	public static boolean checkLoggedIn() {
		return isLoggedIn;
	}
	
	// Get the logged in user id
	public static int checkLoggedUserId() {
		return loggedInUserId;
	}
	
	// Get the error id - for password errors
	public static int checkErrorId() {
		return errorId;
	}
	
	// Reset error id
	public static void resetErrorId() {
		errorId = -1;
	}
	
	// Register user to database
	public static void register(String name, String email, String password) {
		FakeDatabase.addNewUser(name, email, password);
	}
	
	// Check that the given password inputs: match the criteria and equal each other
	public static boolean validateRegisterPassword(String password, String confirmPass) {
		if(InputValidationUtil.validPassword(password)) {
			if(password.equals(confirmPass)) {
				return true;
			} else {
				// ErrorId 1: Passwords do no match
				errorId = 1;
				return false;
			}
		} else {
			// Error Id 2: Password does not match criteria
			errorId = 2;
			return false;
		}
	}
	
	// Set log in parameters
	public static void login(String email, String password) {
		isLoggedIn = true;
		loggedInUserId = FakeDatabase.getUserIndex(email, password);
	}
	
	// Check that given email and password are valid
	public static boolean validateLogin(String email, String password) {
		if(InputValidationUtil.validLogin(email, password)) {
			return true;
		}
		
		return false;
	}
	
	// Log out and return to start menu
	public static void logout() {
		isLoggedIn = false;
		loggedInUserId = -1;
	}
	
	// Item Purchase part
	// User sees list of items
	// User is prompted for item index
	// User is prompted for invoice number
	// If new number, create new invoice with that number and add item to it
	// If current number, add item to invoice
	// Return to home page
	public static void purchase(int itemIndex, int invoiceNum, int userId) {
		boolean invoiceExists = false;
		Item purchasedItem = FakeDatabase.getItem(itemIndex);
		Invoice orderInvoice = new Invoice();
		
		// Check if the given invoice number matches one in the database
		for(Invoice iv: FakeDatabase.invoiceList) {
			if(iv.getInvoiceNum() == invoiceNum && iv.getUserId() == userId) {
				invoiceExists = true;
				orderInvoice = iv;
				break;
			}
		}
		
		orderInvoice.addItem(purchasedItem);
		
		// If the invoice didn't exist, set the other information and then create it
		// Otherwise, just update the invoice
		if(!invoiceExists) {
			orderInvoice.setInvoiceNum(invoiceNum);
			orderInvoice.setUserId(userId);
			orderInvoice.setTimeOfCreation(LocalDate.now());
			FakeDatabase.addNewInvoice(orderInvoice);
		} else {
			FakeDatabase.updateInvoice(orderInvoice);
		}
		
	}
	
	// Check that the selected item exists in the database
	public static boolean validatePurchase(int itemIndex) {
		if(FakeDatabase.getItem(itemIndex).getPrice() > -1) {
			return true;
		}
		
		return false;
	}

	// Replace(remove) the item in the selected invoice
	public static void replace(int itemIndex, int invoiceNum) {
		Invoice orderInvoice = FakeDatabase.getInvoice(invoiceNum);
		
		orderInvoice.removeItem(itemIndex - 1);
		
		FakeDatabase.updateInvoice(orderInvoice);
	}
	
	// Check that the given item exists in the invoice to be replaced
	public static boolean validateReplace(int itemIndex, int invoiceNum) {
		Invoice orderInvoice = FakeDatabase.getInvoice(invoiceNum);
		if(InputValidationUtil.itemExistsInInvoice(itemIndex, orderInvoice)) {
			return true;
		}
		
		return false;
	}
	
	// Check that the invoice belongs to the given user
	public static boolean validateInvoiceBelongsToUser(int invoiceNum, int userId) {
		if(InputValidationUtil.invoiceBelongsToUser(invoiceNum, userId)) {
			return true;
		}
		
		return false;
	}

}
