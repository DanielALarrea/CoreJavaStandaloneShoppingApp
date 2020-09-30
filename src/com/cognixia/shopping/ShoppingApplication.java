package com.cognixia.shopping;

import com.cognixia.shopping.controller.ShoppingAppController;
import com.cognixia.shopping.repository.FakeDatabase;
import com.cognixia.shopping.utility.ConsoleUtil;

public class ShoppingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenuTests();
//		runLogicTests();
	}
	
	private static void runApp() {
		while(true) {
			if(!ShoppingAppController.checkLoggedIn()) {
				// logic for not logged in
				runStartMenu();
			} else {
				// logic for logged in
				runHomeMenu();
			}
		}
	}
	
	private static void runStartMenu() {
		System.out.println(ConsoleUtil.startMenu());
	}
	
	private static void runHomeMenu() {
		System.out.println(ConsoleUtil.homeMenu());
	}
	
	private static void runItemMenu() {
		System.out.println(ConsoleUtil.itemMenu());
	}
	
	private static void runInvoiceMenu(int invoiceNum, String customerName) {
		// Need to start with an invoice option
		System.out.println(ConsoleUtil.invoiceMenu(invoiceNum, customerName));
	}
	
	public static void runMenuTests() {
		FakeDatabase.init();
		
//		System.out.println(ConsoleUtil.startMenu());
		
//		System.out.println(ConsoleUtil.homeMenu());
		
		System.out.println(ConsoleUtil.itemMenu());
		
//		System.out.println(ConsoleUtil.invoiceMenu(1, "Daniel"));
//		
//		ShoppingAppController.purchase(1, 1);
		
		System.out.println(ConsoleUtil.invoiceMenu(1, "Daniel"));
		
//		ShoppingAppController.purchase(1, 2);
//		
//		System.out.println(ConsoleUtil.invoiceMenu(2, "Daniel"));
		
		ShoppingAppController.replace(1, 1);
		
		System.out.println(ConsoleUtil.invoiceMenu(1, "Daniel"));
	}
	
	public static void runLogicTests() {
		//FakeDatabase.init();
		
		if(ShoppingAppController.validateRegisterPassword("validpass", "validpass")) {
			ShoppingAppController.register("email.com", "validpass");
		}
		System.out.println(ShoppingAppController.checkLoggedIn());
		System.out.println(ShoppingAppController.checkLoggedUserId());
		
		if(ShoppingAppController.validateLogin("email.com", "validpass")) {
			ShoppingAppController.login("email.com", "validpass");
		}
		System.out.println(ShoppingAppController.checkLoggedIn());
		System.out.println(ShoppingAppController.checkLoggedUserId());
		
		ShoppingAppController.logout();
		System.out.println(ShoppingAppController.checkLoggedIn());
		System.out.println(ShoppingAppController.checkLoggedUserId());
		// These two should fail
//		ShoppingAppController.login("Notemail", "notpassword");
//		ShoppingAppController.register("email.com", "validpass", "invalidpass");
	}

}
