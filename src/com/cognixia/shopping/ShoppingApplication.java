package com.cognixia.shopping;

import com.cognixia.shopping.utility.ConsoleUtil;

public class ShoppingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenuTests();
	}
	
	public static void runMenuTests() {
		System.out.println(ConsoleUtil.startMenu());
		
		System.out.println(ConsoleUtil.homeMenu());
	}

}
