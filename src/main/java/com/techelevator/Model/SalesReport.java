package com.techelevator.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


public class SalesReport {
    private Map<String, Integer> quantitySold = new HashMap<String, Integer>();
    private double salesTotal = 0;//

    //public Map<String, Integer> getQuantitySold(){return this.quantitySold;}

    public double getSalesTotal(){
        return this.salesTotal;
    }

    //This method collects the product name and the quantity sold and saves it in a text file
    public void writeReport() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();


        // Time formater
        DateTimeFormatter timeFormat = DateTimeFormatter.ISO_TIME;
        String timeString = time.truncatedTo(ChronoUnit.SECONDS).format(timeFormat);


        try(PrintWriter transactions = new PrintWriter("src/main/java/com/techelevator/SalesReports/SalesReport"+ date + timeString +".txt")) {
            Inventory vendingInventory = Inventory.getInventoryInstance();

            //transactions.printf("%-25s %-10s", "Product", "Amount Sold");
            //transactions.println();
            //transactions.println("-------------------------------------");
            //generate report to write to file

            for (Product item : vendingInventory.getInventory()) {
                quantitySold.put(item.getItemName(), item.getItemsSold());
                this.salesTotal += item.getItemsSold() * item.getItemPrice();

            }
            for (Map.Entry<String, Integer> soldItem : quantitySold.entrySet()) {
                String name = soldItem.getKey();
                int sold = soldItem.getValue();
                transactions.println(name + "|" + sold);
                //transactions.printf("%-25s %-1s\n", name, sold);
            }
            transactions.println();
            //transactions.println("--------------------------------");
            transactions.printf("**SALES TOTAL** $%.2f", getSalesTotal());
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    //This method reads the text file and prints it out to the user
    //William Haywood says this isn't required.
    /*
    public void readReport() {


        File report = new File("");

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
*/

}
