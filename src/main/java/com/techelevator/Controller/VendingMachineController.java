package com.techelevator.Controller;

import com.techelevator.Model.Inventory;
import com.techelevator.Model.Product;
import com.techelevator.Model.Balance;
import com.techelevator.Model.SalesReport;

import java.io.File;
import java.util.Map;

/**
 * <h1>Controller</h1>
 * Controller is a class that handles user requests.
 * It retrieves data from the Model and renders view as response.
 * <p>
 * <b>Note:</b> keep your methods static so you don't need to
 * create an instance of the VendingMachineController.
 *
 * @author  Everyone
 * @version 1.0
 * @since   2022-12-10
 */

public class VendingMachineController {
    // Instance of Inventory
    private static Inventory vendingInventory = Inventory.getInventoryInstance();

    /**
     * This method is used to display every
     * product in the (vendingmachine.csv) file. The fields
     * that are printed out are ItemSlot, ItemName, ItemPrice, and ItemType.
     *
     */
    public static void displayInventory(){
        System.out.println();
        System.out.printf("%-10s %-20s %-11s %-10s %s\n", "Slot", "Product Name", "Price", "Type", "Quantity");
        System.out.println("_______________________________________________________________");
        System.out.println();


        for(Product item: vendingInventory.getInventory()){

            // tests if Item is sold out or not
            if(item.isOutOfStock()){
                System.out.printf("%-10s %-20s $%-10.2f %-10s %s\n", item.getItemSlot(), item.getItemName(), item.getItemPrice(), item.getItemType(), "Sold Out");
            }else{
                System.out.printf("%-10s %-20s $%-10.2f %-10s %d\n", item.getItemSlot(), item.getItemName(), item.getItemPrice(), item.getItemType(), item.getItemQuantity());
            }

        }
    }


    //adds to file "SalesReport.txt" displaying the product and how many were sold.
    public static void displaySalesReport(){
        SalesReport mySalesReport = new SalesReport();
        mySalesReport.writeReport();
        System.out.println("Sales Report printed to Sales Folder");


    }





}