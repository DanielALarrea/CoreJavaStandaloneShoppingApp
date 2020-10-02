package com.cognixia.shopping.utility;

public class ResponseUtil {
	
	// Display when user completes registrations
	public static String register() {
		return "Registration complete. Thank you for registering with Shopping!";
	}
	
	// Display when user logs in
	public static String login() {
		return "Logged in. Please select an option";
	}
	
	// Display when user logs out
	public static String logout() {
		return "Logging out...";
	}
	
	// Display when user exits the application
	public static String exit() {
		return "Closing application. We hope to see you again!";
	}
	
	// Display when no invoice is found while purchasing item - asks user to confirm creation
	public static String creatingInvoice(int invoiceNum) {
		return "No invoice found for " + invoiceNum + ". Create a new invoice for " + invoiceNum + "? (Y/N)";
	}
	
	// Display when user chooses not to create new invoice
	public static String notCreatingInvoice() {
		return "Will not create invoice. Returning to home.";
	}
	
	// Display after purchasing item
	public static String addItemToInvoice(String itemCode, int invoiceNum) {
		return "Adding " + itemCode + " to invoice " + invoiceNum;
	}
	
	// Display after replacing item
	public static String replaceItemInInvoice(String itemCode, int invoiceNum) {
		return "Replacing " + itemCode + " in invoice " + invoiceNum + ". Please wait up to 15 business days while we check the validity of the item.";
	}

}
