package com.techelevator.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesReport {
    private Map<String, Integer> quantitySold = new HashMap<String, Integer>();
    private double salesTotal = 0;//


    public double getSalesTotal(){
        return this.salesTotal;
    }

    //This method collects the product name and the quantity sold and saves it in a text file
    public void writeReport() {
        try {
            PrintWriter transactions = new PrintWriter("src/main/java/com/techelevator/SalesReport.txt");
            Inventory vendingInventory = Inventory.getInventoryInstance();

            //generate report to write to file

            for(Product item: vendingInventory.getInventory()) {
                quantitySold.put(item.getItemName(), item.getItemsSold());
                this.salesTotal += item.getItemsSold() * item.getItemPrice();

                //write data to the file

                transactions.println(quantitySold);
            }
            transactions.println(salesTotal);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    //This method reads the text file and prints it out to the user
    public void readReport() {
        File report = new File("src/main/java/com/techelevator/SalesReport.txt");
        try {
            Scanner sales = new Scanner(report);
            while (sales.hasNextLine()) {
                String nextTransaction = sales.nextLine();
                System.out.println(nextTransaction);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }


}
