package com.cognixia.shopping.controller;

import com.cognixia.shopping.repository.FakeDatabase;
import com.cognixia.shopping.utility.InputValidationUtil;

public class ShoppingAppController {
	
	public void register(String email, String password, String confirmPass) {
		if(InputValidationUtil.validPassword(password) && password.equals(confirmPass)) {
			FakeDatabase.addNewUser(email, password);
		}
	}
	
	public void login(String email, String password) {
		if(InputValidationUtil.validLogin(email, password)) {
			System.out.println("Valid Login, proceeding to next page");
			// Go to next page
		}
	}
	
	// Invoice Replace part
	// User selects Replace Item
	// User is prompted for invoice number
	// User is prompted for item code in invoice
	// Some kind of date check for 15 days?
	// Return item ?????
	
	public void replace() {
		
	}

	public void purchase() {
		
	}
}
