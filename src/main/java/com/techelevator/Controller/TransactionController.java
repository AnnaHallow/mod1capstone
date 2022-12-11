package com.techelevator.Controller;

import com.techelevator.Model.Inventory;
import com.techelevator.Model.Transaction;

public class TransactionController {
    public static Transaction vendingTransaction = Transaction.getTransactionInstance();
    public static Inventory vendingInventory = Inventory.getInventoryInstance();

    public static void displayCurrentBalance(){
        System.out.printf("Current Money Provided: $%.2f\n", vendingTransaction.getBalance());
    }

    public static void feedMoney(){

    }

    public static void purchaseProduct(){

    }

    public static void finishTransaction(){

    }


}
