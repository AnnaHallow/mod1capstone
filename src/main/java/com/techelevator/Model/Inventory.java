package com.techelevator.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Inventory</h1>
 * This class reads each line from the (vendingmachine.csv) file
 * and saves each item as a Product datatype in a ArrayList.You can access
 * this ArrayList by calling the getInventory() method. The class
 * is a using the singleton pattern so you can only one instance of the
 * class at a time.
 * <p>
 * <b>Note:</b> to create an instance of this class write
 * Inventory newInventory = Inventory.getInstance();
 *
 * @author  Wyatt Olsen
 * @version 1.0
 * @since   2022-12-10
 */
public class Inventory {
    private List<Product> inventory;
    private static Inventory firstInstance = null;

    private Inventory(){

        this.inventory = makeInventory();
    }

    // makes only one instance of the class
    public static Inventory getInventoryInstance(){
        if(firstInstance == null){
            firstInstance = new Inventory();
        }
        return firstInstance;
    }

    /**
     * This method makes an ArrayList of product
     * by reading line by line from the (vendingmachine.csv) file.
     *
     *
     * @return List<Products> this returns the list of products
     */
    private List<Product> makeInventory(){
        List<Product> inventory = new ArrayList<Product>();

        // Reading inventory from file
        File inventoryFile = new File("vendingmachine.csv");
        try(Scanner inventoryScanner = new Scanner(inventoryFile)){
            while(inventoryScanner.hasNextLine()){
                String[] inventoryArray = inventoryScanner.nextLine().split("\\|");
                Product newProduct = new Product(inventoryArray[0], inventoryArray[1], Double.parseDouble(inventoryArray[2]), inventoryArray[3]);//parse double later
                inventory.add(newProduct);
            }

        }catch(FileNotFoundException e){
            System.out.println(e);
        }

        return inventory;
    }


    /**
     * This method is used to search through the
     * inventory for a product at a certain slot in the
     * vending machine.
     * @param slotLocation this is the slot that will be searched for a product
     * @return Product from the slot and null if no slot was found
     */
    public Product searchInventory(String slotLocation){
        for(Product item: this.getInventory()){
            if(item.getItemSlot().equals(slotLocation)){
                return item;
            }
        }
        return null;
    }

    public List<Product> getInventory(){
        return this.inventory;
    }
}

