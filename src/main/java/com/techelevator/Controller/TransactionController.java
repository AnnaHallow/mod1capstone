package com.techelevator.Controller;

import com.techelevator.Exceptions.ProductNotFoundException;
import com.techelevator.Model.Inventory;
import com.techelevator.Model.Balance;

public class TransactionController {
    public static Balance vendingBalance = Balance.getBalanceInstance();
    public static Inventory vendingInventory = Inventory.getInventoryInstance();

    public static void displayCurrentBalance(){
        System.out.printf("Current Money Provided: $%.2f\n", vendingBalance.getBalance());
    }

    public static void feedMoney(){

    }

    public static void purchaseProduct(){

    }

    public static void finishTransaction(){

    }


}
