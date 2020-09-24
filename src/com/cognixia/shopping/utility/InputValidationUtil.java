package com.cognixia.shopping.utility;

import com.cognixia.shopping.model.Invoice;
import com.cognixia.shopping.model.Item;
import com.cognixia.shopping.model.User;
import com.cognixia.shopping.repository.FakeDatabase;

// Contains methods to check user input
public class InputValidationUtil {

	// Check that the password matches the criteria
	// Criteria: Length greater than 8
	public static boolean validPassword(String password) {
		if (password.length() > 8) {
			return true;
		} else {
			return false;
		}
	}
	
	// Check that the given email and password match a user's credentials
	public static boolean validLogin(String email, String password) {
		for(User u: FakeDatabase.userList) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	
	// Check that an item exists for the given item code
	public static boolean itemExists(String itemCode) {
		for(Item i: FakeDatabase.itemList) {
			if(i.getCode().equals(itemCode)) {
				return true;
			}
		}
		
		return false;
	}
	
	// Check that an invoice exists for the given invoice number
	public static boolean invoiceExists(int invoiceNum) {
		for(Invoice iv: FakeDatabase.invoiceList) {
			if(iv.getInvoiceNum() == invoiceNum) {
				return true;
			}
		}
		return false;
	}
	
	// Check that the item exists in the invoice
	public static boolean itemExistsInInvoice(String itemCode, Invoice iv) {
		for(Item i: iv.getItemList()) {
			if(i.getCode().equals(itemCode)) {
				return true;
			}
		}
		
		return false;
	}
}
