package com.techelevator.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
