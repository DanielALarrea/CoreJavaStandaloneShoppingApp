package com.cognixia.shopping;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.shopping.controller.ShoppingAppController;
import com.cognixia.shopping.model.Invoice;
import com.cognixia.shopping.repository.FakeDatabase;
import com.cognixia.shopping.utility.ConsoleUtil;
import com.cognixia.shopping.utility.ErrorUtil;
import com.cognixia.shopping.utility.InputValidationUtil;
import com.cognixia.shopping.utility.ResponseUtil;

public class ShoppingApplication {

	public static void main(String[] args) {
		runApp();
	}
	
	private static void runApp() {
		// Inititalize the fake database, mostly to populate the items
		FakeDatabase.init();
		Scanner scan = new Scanner(System.in);
		
		// Menu loop
		while(true) {
			// Check for logged in status to determine which menu to display
			if(!ShoppingAppController.checkLoggedIn()) {
				// logic for not logged in
				runStartMenu(scan);
			} else {
				// logic for logged in
				runHomeMenu(scan);
			}
		}
	}
	
	// Menu when starting the app and not logged in
	private static void runStartMenu(Scanner scan) {
		int menuChoice = -1;
		String nameInput = "";
		String emailInput = "";
		String passInput = "";
		String confirmPassInput = "";
		System.out.println(ConsoleUtil.startMenu());
		System.out.println(ConsoleUtil.askInput());
		
		// Check that there are no mismatched inputs
		// scan.nextLine clears delimited inputs if there are any spaces in the input
		try {
			menuChoice = scan.nextInt();
			scan.nextLine();

			/*
			 * Menu Options:
			 * 1: Register
			 * 2: Login
			 * 3: Exit
			 */
			switch(menuChoice) {
			case 1:
				// Receive inputs for registering
				System.out.println(ConsoleUtil.askName());
				nameInput = scan.nextLine();
				scan.nextLine();
				System.out.println(ConsoleUtil.askEmail());
				emailInput = scan.next();
				scan.nextLine();
				System.out.println(ConsoleUtil.askPasswordCriteria());
				passInput = scan.next();
				scan.nextLine();
				System.out.println(ConsoleUtil.askConfirmPassword());
				confirmPassInput = scan.next();
				scan.nextLine();

				// Process inputs
				if(ShoppingAppController.validateRegisterPassword(passInput, confirmPassInput)) {
					System.out.println(ResponseUtil.register());
					ShoppingAppController.register(nameInput, emailInput, passInput);
				} else {
					// Determine if the error was from password not meeting criteria or password not matching confirm password
					if(ShoppingAppController.checkErrorId() == 1) {
						System.out.println(ErrorUtil.errorPasswordMatch());
					} else if (ShoppingAppController.checkErrorId() == 2) {
						System.out.println(ErrorUtil.errorPasswordCriteria());
					}
				}
				ShoppingAppController.resetErrorId();
				break;
			case 2:
				// Receive inputs
				System.out.println(ConsoleUtil.askEmail());
				emailInput = scan.next();
				scan.nextLine();
				System.out.println(ConsoleUtil.askPassword());
				passInput = scan.next();
				scan.nextLine();

				// Process inputs
				if(ShoppingAppController.validateLogin(emailInput, passInput)) {
					System.out.println(ResponseUtil.login());
					// Sets logged in status
					// Also sets logged in user id
					ShoppingAppController.login(emailInput, passInput);
				} else {
					System.out.println(ErrorUtil.errorLogin());
				}
				break;
			case 3:
				System.out.println(ResponseUtil.exit());
				System.exit(0);
				scan.close();
				break;
			default:
				// Some number input that wasn't an option
				System.out.println(ErrorUtil.errorMenu());
				break;
			} 
		} catch (InputMismatchException ime) {
			System.out.println(ErrorUtil.errorMenu());
			scan.nextLine();
		}
	}
	
	// Menu when logged in
	private static void runHomeMenu(Scanner scan) {
		int menuChoice = -1;
		int invoiceChoice = -1;
		int loggedInUser = ShoppingAppController.checkLoggedUserId();
		System.out.println(ConsoleUtil.homeMenu());
		System.out.println(ConsoleUtil.askInput());
		
		try {
			menuChoice = scan.nextInt();
			scan.nextLine();

			/*
			 * Menu Options:
			 * 1: Buy an Item
			 * 2: Replace an Item
			 * 3: Log out
			 */
			switch(menuChoice) {
			case 1:
				// Switch to the item menu
				runItemMenu(scan);
				break;
			case 2:
				// Before proceeding to invoice menu, ask for invoice number
				System.out.println(ConsoleUtil.askInvoiceNumber());
				invoiceChoice = scan.nextInt();
				scan.nextLine();
				
				// Check that the given invoice number belongs to the logged in user
				if(ShoppingAppController.validateInvoiceBelongsToUser(invoiceChoice, loggedInUser)) {
					runInvoiceMenu(scan, invoiceChoice, FakeDatabase.getUserNameByIndex(loggedInUser));
				} else {
					System.out.println(ErrorUtil.errorInvoice());
				}
				break;
			case 3:
				System.out.println(ResponseUtil.logout());
				ShoppingAppController.logout();
				break;
			default:
				System.out.println(ErrorUtil.errorMenu());
				break;
			}
		} catch (InputMismatchException ime) {
			System.out.println(ErrorUtil.errorMenu());
			scan.nextLine();
		}
	}
	
	private static void runItemMenu(Scanner scan) {
		int menuChoice = -1;
		int invoiceChoice = -1;
		String createInvoice = "";
		System.out.println(ConsoleUtil.itemMenu());
		System.out.println(ConsoleUtil.askItemIndex());
		
		try {
			menuChoice = scan.nextInt();
			scan.nextLine();

			if(menuChoice >= 1 && menuChoice <= FakeDatabase.itemList.size() + 1) {
				for(int j = 1; j <= FakeDatabase.itemList.size(); j++) {
					if(j == menuChoice) {
						if(ShoppingAppController.validatePurchase(menuChoice)) {
							System.out.println(ConsoleUtil.askInvoiceNumber());
							invoiceChoice = scan.nextInt();
							scan.nextLine();
							if(InputValidationUtil.invoiceExists(invoiceChoice)) {
								if(ShoppingAppController.validateInvoiceBelongsToUser(invoiceChoice, ShoppingAppController.checkLoggedUserId())) {
									System.out.println(ResponseUtil.addItemToInvoice(FakeDatabase.getItem(menuChoice).getCode(), invoiceChoice));
									ShoppingAppController.purchase(menuChoice, invoiceChoice, ShoppingAppController.checkLoggedUserId());
									break;
								} else {
									System.out.println(ErrorUtil.errorInvoiceExists());
									break;
								}
							} else {
								System.out.println(ResponseUtil.creatingInvoice(invoiceChoice));
								createInvoice = scan.next();
								scan.nextLine();
								if(createInvoice.equalsIgnoreCase("Y")) {
									System.out.println(ResponseUtil.addItemToInvoice(FakeDatabase.getItem(menuChoice).getCode(), invoiceChoice));
									ShoppingAppController.purchase(menuChoice, invoiceChoice, ShoppingAppController.checkLoggedUserId());
									break;
								} else if (createInvoice.equalsIgnoreCase("N")) {
									System.out.println(ResponseUtil.notCreatingInvoice());
									break;
								} else {
									System.out.println(ErrorUtil.errorMenu());
								}
							}
						} else {
							System.out.println(ErrorUtil.errorItem());
							break;
						}
					} else if (menuChoice == FakeDatabase.itemList.size() + 1) {
						break;
					}
				}
			} else {
				System.out.println(ErrorUtil.errorMenu());
			} 
		} catch (InputMismatchException ime) {
			System.out.println(ErrorUtil.errorMenu());
			scan.nextLine();
		}
		
		runHomeMenu(scan);
	}
	
	private static void runInvoiceMenu(Scanner scan, int invoiceNum, String customerName) {
		int itemChoice = -1;
		Invoice currentInvoice = FakeDatabase.getInvoice(invoiceNum);
		// Need to start with an invoice option
		System.out.println(ConsoleUtil.invoiceMenu(invoiceNum, customerName, currentInvoice.getTimeOfCreation()));
		System.out.println(ConsoleUtil.askItemIndex());
		try {
			itemChoice = scan.nextInt();
			scan.nextLine();

			if(itemChoice >= 1 && itemChoice <= currentInvoice.getItemList().size() + 1) {
				for(int i = 1; i <= currentInvoice.getItemList().size(); i++) {
					if(i == itemChoice) {
						System.out.println(ResponseUtil.replaceItemInInvoice(FakeDatabase.getItem(itemChoice).getCode(), invoiceNum));
						ShoppingAppController.replace(i, invoiceNum);
						break;
					} else if (itemChoice == currentInvoice.getItemList().size() + 1) {
						break;
					}
				}
			} else {
				System.out.println(ErrorUtil.errorMenu());
			}
		} catch (InputMismatchException ime) {
			System.out.println(ErrorUtil.errorMenu());
			scan.nextLine();
		}
		
		runHomeMenu(scan);
	}

}
