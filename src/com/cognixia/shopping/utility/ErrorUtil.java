package com.cognixia.shopping.utility;

// Contains messages to display when an error occurs
public class ErrorUtil {
	
	// Display when registering and password does not match criteria
	public static String errorPasswordCriteria() {
		return "That password does not match the criteria";
	}
	
	// Display when registering and password does not match the confirmation password
	public static String errorPasswordMatch() {
		return "The passwords do not match";
	}
	
	// Display when logging in and given credentials do not match any user in the system
	public static String errorLogin() {
		return "No entry matching email and password found";
	}
	
	// Display when user attempts to purchase an item that does not exist
	public static String errorItem() {
		return "Item not found";
	}
	
	// Display when user attempts to bring up an invoice that does not exist
	public static String errorInvoice() {
		return "Invoice not found";
	}
	
	// Display when user attempts to replace an item on an invoice that is not on the invoice
	public static String errorReplaceItem() {
		return "Item not on invoice";
	}

}
