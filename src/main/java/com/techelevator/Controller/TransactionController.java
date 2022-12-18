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

        do {
            System.out.println("Enter deposit: ");
            double tempCash = 0.0;


            try {tempCash += scan.nextDouble(); }
            catch (Exception e){
                System.err.println("Must be whole dollars.");
            }

            vendingBalance.depositMoney(tempCash);


            System.out.println("Add additional tender? Y/N");
            TransactionController.displayCurrentBalance();
            String choice = scan.next();
            if (choice.equalsIgnoreCase("y")) {


            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("You have added $" + tempCash);
                System.out.println("Current balance is: $" + (vendingBalance.getBalance()));
                stillAdding = false;

            } else {
                System.out.println("Invalid selection");
            }

        }while(stillAdding);

    }

    public static void purchaseProduct(){
        Scanner scan = new Scanner(System.in);
        if (vendingBalance.getBalance() == 0) {
            System.out.println("Please submit additional tender.");
        } else {
            System.out.println("Enter item location: ");
            String slotLocation = scan.nextLine();


            try {
                Product newProduct = vendingInventory.searchInventory(slotLocation);

                //Product newProduct = vendingInventory.searchInventory(slotLocation);


                if (vendingBalance.getBalance() < newProduct.getItemPrice()) {
                    System.out.println("Please submit additional tender. Product Price: $" + newProduct.getItemPrice());
                    TransactionController.feedMoney();
                } else {
                    try {

                        newProduct.removeOneItem();
                        vendingBalance.subtractFromBalance(newProduct.getItemPrice());
                        System.out.println("Dispensing: " + newProduct.getItemName() + " at $" + newProduct.getItemPrice());
                        //print out sounds
                        System.out.println(noiseMaker(newProduct.getItemType()));
                        System.out.println("Remaining balance: $" + vendingBalance.getBalance());


                    }catch(ProductSoldOutException e){
                        System.out.println("Item is out of stock");
                    }
                }
            } catch (ProductNotFoundException e) {
                //throw new RuntimeException(e)
                System.out.println("Product not found");
            }

            //Product newProduct = vendingInventory.searchInventory(slotLocation);

        }



    }


        public static String noiseMaker(String type){
            //String type = newProduct.getType;
            String sound;

            switch(type){
                case "Chip": sound = "Crunch Crunch, Yum!";
                    break;
                case "Candy": sound = "Munch Munch, Yum!";
                    break;
                case "Drink": sound = "Glug Glug, Yum!";
                    break;
                case "Gum": sound = "Chew Chew Yum!";
                    break;
                default: sound = "What does the fox say?";
                    break;
            }
            return sound;
        }


    public static void finishTransaction(){
        System.out.println("Thank you!");
        if (vendingBalance.getBalance() > 0){
            System.out.println(giveChange(vendingBalance.getBalance()));
            System.out.println("Dispensing Change: $" + vendingBalance.getChange());
            //System.out.println(giveChange(vendingBalance.getBalance()));
            System.out.println("Have a great day!");
        }else {
            System.out.println("Have a nice day!");
        }
    }

    public static String giveChange(double cash){
        int quarters =0;
        int dimes =0;
        int nickels =0;
        int pennies=0;
        int coins = (int) (cash * 100);

        //Used this to test the formula to make change!
        //System.out.println("COINS: " + coins);

        while(coins > 0){
            if (coins >= 25){
                coins -= 25;
                quarters++;
            } else if (coins >= 10){
                coins -= 10;
                dimes++;
            } else if (coins >= 5){
                coins -= 5;
                nickels++;
            } else{
                pennies = coins;
                coins = 0;
            }
        }
        String change = "Change is: " + quarters + " Quarters, " + dimes + " Dimes, " + nickels + " Nickels, " + pennies + " Pennies." ;


        return change;


    }


}
