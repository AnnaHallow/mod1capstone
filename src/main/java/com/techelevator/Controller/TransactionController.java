package com.techelevator.Controller;

import com.techelevator.Exceptions.ProductNotFoundException;
import com.techelevator.Exceptions.ProductSoldOutException;
import com.techelevator.Model.Inventory;
import com.techelevator.Model.Balance;
import com.techelevator.Model.Log;
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
            double tempCash = 0;
            boolean isDepositValid;
            do {
                isDepositValid = true;
                System.out.println("Enter whole dollar deposit ($0, $1, $5, $10, $20): ");
                tempCash = 0;


                try {
                    tempCash += Double.parseDouble(scan.next());
                } catch (Exception e) {
                    System.err.println("Must be whole dollars.");
                    isDepositValid = false;
                }
                // test if cash is in whole dollar amounts
                if(!(isWholeDollar(tempCash))){
                    System.err.println("Must be whole dollars.");
                    isDepositValid = false;
                }

            }while(!(isDepositValid));
            vendingBalance.depositMoney(tempCash);
            Log.log("FEED MONEY:", tempCash,vendingBalance.getBalance());


            System.out.println("Add additional tender? Y/N");
            TransactionController.displayCurrentBalance();
            String choice = scan.next();
            if (choice.equalsIgnoreCase("y")) {
                //this is blank on purpose! It keeps the Y input as valid, while continuing the loop.


            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("You have added $" + tempCash);
                stillAdding = false;
                //Stop adding tender and return to purchase menu
            } else {
                System.err.println("Invalid selection");
                stillAdding = false;
                //stops the loop and returns to previous menu
            }

        }while(stillAdding);
            //continues the loop


    }

    public static void purchaseProduct(){
        Scanner scan = new Scanner(System.in);
        if (vendingBalance.getBalance() == 0) {
            System.out.println("Please submit additional tender.");
        } else {
            System.out.println("Enter item location: ");
            String slotLocation = scan.nextLine();
            //holds current selection

            try {
                Product newProduct = vendingInventory.searchInventory(slotLocation);
                //


                if (vendingBalance.getBalance() < newProduct.getItemPrice()) {
                    System.out.println("Please submit additional tender. Product Price: $" + newProduct.getItemPrice());
                    TransactionController.feedMoney();
                } else {
                    try {

                        newProduct.removeOneItem();
                        //removes item from inventory
                        vendingBalance.subtractFromBalance(newProduct.getItemPrice());
                        //subtracts balance from total balance
                        System.out.println("Dispensing: " + newProduct.getItemName() + " at $" + newProduct.getItemPrice());
                        //send to log
                        Log.log(newProduct.getItemName()+ " " + newProduct.getItemSlot(), newProduct.getItemPrice(), vendingBalance.getBalance());
                        //print out sounds
                        System.out.println(noiseMaker(newProduct.getItemType()));



                    }catch(ProductSoldOutException e){
                        System.err.println("Item is out of stock");
                    }
                }
            } catch (ProductNotFoundException e) {
                System.err.println("Product not found");
            }



        }



    }


        public static String noiseMaker(String type){
        //let's make some noise!
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
                    //it should never get here, but it's a fun easter egg!
            }
            return sound;
        }


    public static void finishTransaction(){
        System.out.println("Thank you!");
        if (vendingBalance.getBalance() > 0){
            System.out.println(giveChange(vendingBalance.getBalance()));
            System.out.printf("Dispensing Change: $%.2f\n", vendingBalance.getChange());
            System.out.println("Have a great day!");
        }else {
            System.out.println("Have a nice day!");
            //only runs if there is a $0 balance when exiting
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
        //divide out what change is given
        String change = "Change is: " + quarters + " Quarters, " + dimes + " Dimes, " + nickels + " Nickels, " + pennies + " Pennies." ;
        Log.log("GIVE CHANGE:", cash, 0);
        //send to log

        return change;


    }

    private static boolean isWholeDollar(double tempCash){
        //checks to make sure tender is whole dollars
        if(tempCash == 0.0){
            return true;
        }else if(tempCash == 1.0){
            return true;
        }else if(tempCash == 5.0){
            return true;
        }else if(tempCash == 10.0){
            return true;
        }else if(tempCash == 20.0){
            return true;
        }else{
            return false;
        }
    }


}
