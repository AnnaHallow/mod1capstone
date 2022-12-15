package com.techelevator.Model;


import com.techelevator.Exceptions.ProductSoldOutException;

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
    private int itemsSold = 0; //starts at zero items sold

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

    public int getItemsSold(){ return itemsSold;}

    public void removeOneItem() throws ProductSoldOutException {

        if(!isOutOfStock()){
            this.itemQuantity -= 1;
            this.itemsSold += 1;
        }else{
            throw new ProductSoldOutException("Product is sold out");
        }

    }


    public boolean isOutOfStock(){
        if(this.getItemQuantity() == 0){
            return true;
        }
        return false;
    }

    public String toString(){
        return this.itemSlot + ", " + this.getItemName() + ", " + this.getItemPrice() + ", " + this.getItemType();
    }

}
