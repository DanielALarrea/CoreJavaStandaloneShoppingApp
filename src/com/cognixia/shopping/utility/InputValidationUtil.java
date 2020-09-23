package com.cognixia.shopping.utility;

import com.cognixia.shopping.model.User;
import com.cognixia.shopping.repository.FakeDatabase;

public class InputValidationUtil {

	public static boolean validPassword(String password) {
		if (password.length() > 8) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validLogin(String email, String password) {
		for(User u: FakeDatabase.userList) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	
}
