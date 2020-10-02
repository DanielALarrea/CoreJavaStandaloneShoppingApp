package com.cognixia.shopping.utility;

import java.time.LocalDate;
import java.util.List;

import com.cognixia.shopping.model.Item;
import com.cognixia.shopping.repository.FakeDatabase;

// Contains strings to display as UI
public class ConsoleUtil {
	
	// Ask for input string
	public static String askInput() {
		return "Choice: ";
	}
	
	public static String askName() {
		return "Name: ";
	}
	
	public static String askEmail() {
		return "Email: ";
	}
	
	public static String askPassword() {
		return "Password: ";
	}
	
	public static String askPasswordCriteria() {
		return "Password - 8 or more characters required: ";
	}
	
	public static String askConfirmPassword() {
		return "Confirm password: ";
	}
	
	public static String askInvoiceNumber() {
		return "Invoice number: ";
	}
	
	public static String askCreateInvoice() {
		return "Create a new invoice? (Y/N) ";
	}
	
	public static String askItemIndex() {
		return "Item index: ";
	}
	
	// Internal utility strings

	private static String lineBreak() {
		return "\n";
	}
	
	private static String blockEdge() {
		return "+===============================================+" + lineBreak();
	}
	
	// Header for most menus
	private static String header() {
		return "           Standalone E-commerce App" + lineBreak();
	}
	
	// Header when in invoice menu
	private static String headerInvoice() {
		return "       Standalone E-commerce App Invoice" + lineBreak();
	}
	
	private static String printSpaces(int spaceCount) {
		String spaces = "";
		for(int j = 0; j < spaceCount; j++) {
			spaces += " ";
		}
		
		return spaces;
	}
	
	// Menu Display Section
	
	// Start menu - when not logged in
	public static String startMenu() {
		String startMenu = header();
		startMenu += blockEdge();
		startMenu += "|    1. REGISTER                                |" + lineBreak();
		startMenu += "|    2. LOGIN                                   |" + lineBreak();
		startMenu += "|    3. EXIT                                    |" + lineBreak();
		startMenu += blockEdge();
		return startMenu;
	}
	
	// Home Menu - when logged in
	public static String homeMenu() {
		String homeMenu = header();
		homeMenu += blockEdge();
		homeMenu += "|    1. BUY AN ITEM                             |" + lineBreak();
		homeMenu += "|    2. REPLACE AN ITEM                         |" + lineBreak();
		homeMenu += "|    3. LOGOUT                                  |" + lineBreak();
		homeMenu += blockEdge();
		return homeMenu;
	}
	
	// Item Menu - Display all available items in database
	public static String itemMenu() {
		int index = 0;
		List<Item> items = FakeDatabase.itemList;
		String itemName = "";
		String itemCode = "";
		float itemPrice = -1;
		String itemPriceString = "";
		
		String itemMenu = header();
		itemMenu += blockEdge();
		itemMenu += "|       Item       Item Code       Price        |" + lineBreak();
		// Create item list based on items in database
		for(int i = 1; i < items.size() + 1; i++) {
			itemName = items.get(i - 1).getName();
			itemCode = items.get(i - 1).getCode();
			itemPrice = items.get(i - 1).getPrice();
			itemPriceString = Float.toString(itemPrice);
			
			itemMenu += "|    " + i + ". " + itemName
					 // 14 characters between front of Name and Item code, expected length of item code is 3
					 + printSpaces(14 - itemName.length()) + itemCode
					 // 12 characters between front of Item code and Price, max expected length of price is 5, add some leading spaces
					 + printSpaces(12 - itemCode.length()) + printSpaces(5 - itemPriceString.length()) + "$" + itemPrice
					 // 8 characters between Price and end
					 + printSpaces(8) + "|" +  lineBreak();
			index = i;
		}
		itemMenu += "|    " + (index + 1) + ". EXIT                                    |" + lineBreak();
		itemMenu += blockEdge();
		return itemMenu;
	}
	
	// Invoice Menu - Display invoice
	public static String invoiceMenu(int invoiceNum, String customerName, LocalDate invoiceDate) {
		int index = 0;
		List<Item> items = FakeDatabase.getInvoice(invoiceNum).getItemList();
		String itemName = "";
		String itemCode = "";
		float itemPrice = -1;
		String itemPriceString = "";
		float totalPrice = 0;
		
		String invoiceMenu = headerInvoice();
		invoiceMenu += blockEdge();
		invoiceMenu += "|  Customer Name : " + customerName + "  Date: " + invoiceDate + printSpaces(11 - customerName.length()) + "|" + lineBreak();
		invoiceMenu += "|  Invoice No : " + invoiceNum + printSpaces(32 - Integer.toString(invoiceNum).length()) + "|" + lineBreak();
		invoiceMenu += "|       Item       Item Code       Price        |" + lineBreak();
		// Create item list based on items in invoice
		for(int i = 1; i < items.size() + 1; i++) {
			itemName = items.get(i - 1).getName();
			itemCode = items.get(i - 1).getCode();
			itemPrice = items.get(i - 1).getPrice();
			itemPriceString = Float.toString(itemPrice);
			
			invoiceMenu += "|    " + i + ". " + itemName
					 // 14 characters between front of Name and Item code, expected length of item code is 3
					 + printSpaces(14 - itemName.length()) + itemCode
					 // 12 characters between front of Item code and Price, max expected length of price is 5, add some leading spaces
					 + printSpaces(12 - itemCode.length()) + printSpaces(5 - itemPriceString.length()) + "$" + itemPrice
					 // 8 characters between Price and end
					 + printSpaces(8) + "|" +  lineBreak();
			index = i;
			totalPrice += itemPrice;
		}
		invoiceMenu += "|                                               |" + lineBreak();
		// Display total price of items on invoice
		invoiceMenu += "|    Total = $" + (totalPrice) + printSpaces(34 - Float.toString(totalPrice).length()) + "|" + lineBreak();
		invoiceMenu += "|    " + (index + 1) + ". EXIT                                    |" + lineBreak();
		invoiceMenu += blockEdge();
		return invoiceMenu;
	}

}
