package com.cognixia.shopping.utility;

// Contains strings to display as UI
public class ConsoleUtil {

	public static String lineBreak() {
		return "\n";
	}
	
	public static String blockEdge() {
		return "+===============================================+" + lineBreak();
	}
	
	public static String header() {
		return "           Standalone E-commerce App" + lineBreak();
	}
	
	public static String startMenu() {
		String startMenu = header();
		startMenu += blockEdge();
		startMenu += "|    1. REGISTER                                |" + lineBreak();
		startMenu += "|    2. LOGIN                                   |" + lineBreak();
		startMenu += "|    3. EXIT                                    |" + lineBreak();
		startMenu += blockEdge();
		return startMenu;
	}
	
	public static String homeMenu() {
		String homeMenu = header();
		homeMenu += blockEdge();
		homeMenu += "|    1. BUY AN ITEM                             |" + lineBreak();
		homeMenu += "|    2. REPLACE AN ITEM                         |" + lineBreak();
		homeMenu += "|    3. EXIT                                    |" + lineBreak();
		homeMenu += blockEdge();
		return homeMenu;
	}
}
