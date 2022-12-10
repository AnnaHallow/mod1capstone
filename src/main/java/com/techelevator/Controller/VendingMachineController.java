package com.techelevator.Controller;

import com.techelevator.Model.Inventory;
import com.techelevator.Model.Product;

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

    /**
     * This method is used to display every
     * product in the (vendingmachine.csv) file. The fields
     * that are printed out are ItemSlot, ItemName, ItemPrice, and ItemType.
     *
     */
    public static void displayInventory(){
        Inventory vendingInventory = Inventory.getInventoryInstance();

        for(Product item: vendingInventory.getInventory()){
            System.out.println(item.getItemSlot() + " " + item.getItemName() + " $" + item.getItemPrice() + " " + item.getItemType() );
        }
    }


}
