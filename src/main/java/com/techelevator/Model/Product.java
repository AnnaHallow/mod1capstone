package com.techelevator.Model;


/**
 * <h1>Product</h1>
 * This creates a blueprint for each product in
 * the vendingmachine.csv. Each product will have the
 * attributes itemSlot, itemName, itemPrice, itemType, and
 * itemQuantity.
 * <p>
 * <b>Note:</b>
 *
 * @author  Wyatt Olsen
 * @version 1.0
 * @since   2022-12-10
 */

public class Product {
    private String itemSlot;
    private String itemName;
    private Double itemPrice;
    private String itemType;
    private int itemQuantity = 5; // default quantity for all items is 5

    public Product(String itemSlot, String itemName, Double itemPrice, String itemType) {
        this.itemSlot = itemSlot;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
    }

    public String getItemSlot() {
        return itemSlot;
    }


    public String getItemName() {
        return itemName;
    }


    public Double getItemPrice() {
        return itemPrice;
    }


    public String getItemType() {
        return itemType;
    }


    public int getItemQuantity() {
        return itemQuantity;
    }

    public void removeOneItem() {

        if(!isOutOfStock()){
            this.itemQuantity -= 1;
        }

    }


    public boolean isOutOfStock(){
        if(this.getItemQuantity() == 0){
            return true;
        }
        return false;
    }
}
