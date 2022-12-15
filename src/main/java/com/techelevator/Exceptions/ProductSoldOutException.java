package com.techelevator.Exceptions;

public class ProductSoldOutException extends Exception{
    public ProductSoldOutException(String message){
        super(message);
    }
}
