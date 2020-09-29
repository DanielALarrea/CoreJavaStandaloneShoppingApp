package com.cognixia.shopping;

import com.cognixia.shopping.controller.ShoppingAppController;
import com.cognixia.shopping.repository.FakeDatabase;
import com.cognixia.shopping.utility.ConsoleUtil;

public class ShoppingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		runMenuTests();
		runLogicTests();
	}
	
	public static void runMenuTests() {
		FakeDatabase.init();
		
//		System.out.println(ConsoleUtil.startMenu());
		
//		System.out.println(ConsoleUtil.homeMenu());
		
		System.out.println(ConsoleUtil.itemMenu());
		
		System.out.println(ConsoleUtil.invoiceMenu(1));
		
		ShoppingAppController.purchase(1, 1);
		
		System.out.println(ConsoleUtil.invoiceMenu(1));
		
		ShoppingAppController.purchase(1, 2);
		
		System.out.println(ConsoleUtil.invoiceMenu(2));
	}
	
	public static void runLogicTests() {
		//FakeDatabase.init();
		
		ShoppingAppController.register("email.com", "validpass", "validpass");
		System.out.println(ShoppingAppController.checkLoggedIn());
		System.out.println(ShoppingAppController.checkLoggedUserId());
		ShoppingAppController.login("email.com", "validpass");
		System.out.println(ShoppingAppController.checkLoggedIn());
		System.out.println(ShoppingAppController.checkLoggedUserId());
		ShoppingAppController.logout();
		System.out.println(ShoppingAppController.checkLoggedIn());
		System.out.println(ShoppingAppController.checkLoggedUserId());
		// These two should fail
		ShoppingAppController.login("Notemail", "notpassword");
		ShoppingAppController.register("email.com", "validpass", "invalidpass");
	}

}
