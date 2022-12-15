package com.techelevator.ModelTest;

import com.techelevator.Model.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    Product testing1Product = new Product("A1", "Potato Crisps", 3.05, "Chip");
    Product testing2Product = new Product("B1", "Moonpie", 1.80, "Candy");
    Product testing3Product = new Product("C1", "Cola", 1.25, "Drink");
    Product testing4Product = new Product("D3", "Chiclets", 0.75, "Gum");


    @Test
    public void getItemSlotTest(){
        Assert.assertEquals("A1", testing1Product.getItemSlot());
        Assert.assertEquals("B1", testing2Product.getItemSlot());
        Assert.assertEquals("C1", testing3Product.getItemSlot());
        Assert.assertEquals("D3", testing4Product.getItemSlot());

    }

    @Test
    public void getItemNameTest(){
        Assert.assertEquals("Potato Crisps", testing1Product.getItemName());
        Assert.assertEquals("Moonpie", testing2Product.getItemName());
        Assert.assertEquals("Cola", testing3Product.getItemName());
        Assert.assertEquals("Chiclets", testing4Product.getItemName());

    }


    @Test
    public void getItemsSoldTest(){
        Assert.assertEquals(0, testing1Product.getItemsSold());
        Assert.assertEquals(0, testing2Product.getItemsSold());
        Assert.assertEquals(0, testing3Product.getItemsSold());
        Assert.assertEquals(0, testing4Product.getItemsSold());

        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();

        testing2Product.removeOneItem();
        testing2Product.removeOneItem();

        testing3Product.removeOneItem();
        testing3Product.removeOneItem();
        testing3Product.removeOneItem();

        testing4Product.removeOneItem();
        Assert.assertEquals(5, testing1Product.getItemsSold());
        Assert.assertEquals(2, testing2Product.getItemsSold());
        Assert.assertEquals(3, testing3Product.getItemsSold());
        Assert.assertEquals(1, testing4Product.getItemsSold());


    }

    @Test
    public void isItemOutOfStockTest(){
        Assert.assertEquals(false, testing1Product.isOutOfStock());
        Assert.assertEquals(false, testing2Product.isOutOfStock());
        Assert.assertEquals(false, testing3Product.isOutOfStock());
        Assert.assertEquals(false, testing4Product.isOutOfStock());

        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();
        testing1Product.removeOneItem();

        testing2Product.removeOneItem();
        testing2Product.removeOneItem();

        testing3Product.removeOneItem();
        testing3Product.removeOneItem();
        testing3Product.removeOneItem();
        testing3Product.removeOneItem();
        testing3Product.removeOneItem();

        testing4Product.removeOneItem();

        Assert.assertEquals(true, testing1Product.isOutOfStock());
        Assert.assertEquals(false, testing2Product.isOutOfStock());
        Assert.assertEquals(true, testing3Product.isOutOfStock());
        Assert.assertEquals(false, testing4Product.isOutOfStock());


    }


}
