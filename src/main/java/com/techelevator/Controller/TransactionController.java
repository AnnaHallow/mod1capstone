package com.techelevator.Controller;

import com.techelevator.Exceptions.ProductNotFoundException;
import com.techelevator.Model.Inventory;
import com.techelevator.Model.Balance;
import java.util.Scanner;

public class TransactionController {
    public static Balance vendingBalance = Balance.getBalanceInstance();
    public static Inventory vendingInventory = Inventory.getInventoryInstance();

    public static void displayCurrentBalance(){
        System.out.printf("Current Money Provided: $%.2f\n", vendingBalance.getBalance());
    }

    public static void feedMoney(){

    }

    public static void purchaseProduct(){
        Scanner scan = new Scanner(System.in);
        if (vendingBalance.getBalance() == 0){
            System.out.println("Please submit additional tender.");
        }
        else {
            System.out.println("Enter item location: ");
            String slotLocation = scan.nextLine();

            try {
                vendingInventory.searchInventory(slotLocation);
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }


        }
    }

    public static void finishTransaction(){

    }


}
