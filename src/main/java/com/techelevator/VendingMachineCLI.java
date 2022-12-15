package com.techelevator;

import com.techelevator.Controller.TransactionController;
import com.techelevator.Controller.VendingMachineController;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	// Main Menu Options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_CLOSE = "Close";
	private static final String MAIN_MENU_SALES_REPORT = "Sales Report";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_CLOSE};
	// Purchase Product Options
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			menu.addSecretMenuItem(MAIN_MENU_SALES_REPORT); // add secret menu Item
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				VendingMachineController.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				Menu purchaseMenu = new Menu(System.in, System.out);
				purchaseMenuSelection(purchaseMenu);

			} else if(choice.equals(MAIN_MENU_CLOSE)){
				// close program
				System.exit(0);
			} else if(choice.equals(MAIN_MENU_SALES_REPORT)){
				//displays sales report
				VendingMachineController.displaySalesReport();

			}
		}
	}

	public void purchaseMenuSelection(Menu menu){
		boolean isTransactionComplete = false;

		while(!isTransactionComplete){
			System.out.println();
			TransactionController.displayCurrentBalance();
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if(choice.equals(PURCHASE_MENU_FEED_MONEY)){
				// Feed money


			}else if(choice.equals(PURCHASE_MENU_SELECT_PRODUCT)){
				// Select Product
 				TransactionController.purchaseProduct();

			}else if(choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)){
				// Finish transaction

				isTransactionComplete = true;
			}
		}
	}

	public static void main(String[] args) {

		Menu mainMenu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(mainMenu);
		cli.run();
	}
}
