package com.techelevator.Controller;

import com.techelevator.Exceptions.ProductNotFoundException;
import com.techelevator.Exceptions.ProductSoldOutException;
import com.techelevator.Model.Inventory;
import com.techelevator.Model.Balance;
import com.techelevator.Model.Product;

import java.util.Scanner;

public class TransactionController {
    public static Balance vendingBalance = Balance.getBalanceInstance();
    public static Inventory vendingInventory = Inventory.getInventoryInstance();

    public static void displayCurrentBalance(){
        System.out.printf("Current Money Provided: $%.2f\n", vendingBalance.getBalance());
    }

    public static void feedMoney(){
        Scanner scan = new Scanner(System.in);
        boolean stillAdding = true;
        System.out.println("Enter deposit: ");
         double tempCash = 0.0;
        tempCash += scan.nextDouble();

        while(stillAdding){
            System.out.println("Add additional tender? Y/N");
            TransactionController.displayCurrentBalance();
            String choice = scan.next();
            if(choice.equalsIgnoreCase("y")){
                tempCash += scan.nextDouble();

            }else if(choice.equalsIgnoreCase("n")){
                System.out.println("You have added $" + tempCash);
                System.out.println("Current balance is: $" + (TransactionController.vendingBalance.getBalance()) + tempCash);
                stillAdding = false;

            }else {
                System.out.println("Invalid selection");
            }
        }

    }

    public static void purchaseProduct() throws ProductNotFoundException, ProductSoldOutException {
        Scanner scan = new Scanner(System.in);
        if (vendingBalance.getBalance() == 0) {
            System.out.println("Please submit additional tender.");
        } else {
            System.out.println("Enter item location: ");
            String slotLocation = scan.nextLine();

            try {
                vendingInventory.searchInventory(slotLocation);
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }

            Product newProduct = vendingInventory.searchInventory(slotLocation);


            if (vendingBalance.getBalance() < newProduct.getItemPrice()) {
                System.out.println("Please submit additional tender. Product Price: $" + newProduct.getItemPrice());
                TransactionController.feedMoney();
            } else {
                newProduct.removeOneItem();
            }
        }



    }

    public static String noiseMaker(){
        switch (){

        }
    }

    public static void finishTransaction(){
        System.out.println("Thank you!");
        if (vendingBalance.getBalance() > 0){
            System.out.println("Dispensing Change: $" + vendingBalance.getBalance());
            System.out.println("Have a great day!");
        }
    }


}
