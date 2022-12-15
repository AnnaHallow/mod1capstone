package com.techelevator.ModelTest;

import com.techelevator.Exceptions.ProductNotFoundException;
import com.techelevator.Model.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class InventoryTest {
    private Inventory testingInventory = Inventory.getInventoryInstance();


    @Test
    public void searchInventoryTest() {
        try{

            Assert.assertEquals( "A1, Potato Crisps, 3.05, Chip", testingInventory.searchInventory("A1").toString());
            Assert.assertEquals( "B3, Wonka Bar, 1.5, Candy", testingInventory.searchInventory("B3").toString());
            Assert.assertEquals( "C1, Cola, 1.25, Drink", testingInventory.searchInventory("C1").toString());
            Assert.assertEquals( "D3, Chiclets, 0.75, Gum", testingInventory.searchInventory("D3").toString());

        }catch(ProductNotFoundException e){
            System.out.println("The product was not found");
        }
    }




}
