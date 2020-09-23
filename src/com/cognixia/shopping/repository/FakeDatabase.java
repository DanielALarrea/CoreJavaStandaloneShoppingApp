package com.cognixia.shopping.repository;

import java.util.ArrayList;
import java.util.List;

import com.cognixia.shopping.model.Invoice;
import com.cognixia.shopping.model.User;

public class FakeDatabase {
	
	public static List<User> userList = new ArrayList<User>();
	
	public static void addNewUser(String email, String password) {
		userList.add(new User(email, password));
	}

	public static Invoice initInvoice() {
		return new Invoice();
	}
}
