package com.cognixia.shopping.utility;

public class ResponseUtil {
	
	public static String register() {
		return "Registration complete. Thank you for registering with Shopping!";
	}
	
	public static String login() {
		return "Logged in. Please select an option";
	}
	
	public static String logout() {
		return "Logging out...";
	}
	
	public static String creatingInvoice(int invoiceNum) {
		return "No invoice found for " + invoiceNum + ". Creating invoice for " + invoiceNum;
	}
	
	public static String addItemToInvoice(String itemCode, int invoiceNum) {
		return "Adding " + itemCode + " to invoice " + invoiceNum;
	}
	
	public static String replaceItemInInvoice(String itemCode, int invoiceNum) {
		return "Replacing " + itemCode + " in invoice " + invoiceNum;
	}

}
