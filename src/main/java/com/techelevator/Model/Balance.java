package com.techelevator.Model;


/**
 * <h1>Balance</h1>
 * This class handle the balance of the vending machine
 *
 * <p>
 * <b>Note:</b> to create an instance of this class write
 * Balance newBalance = Balance.getInstance();
 *
 * @author
 * @version 1.0
 * @since   2022-12-10
 */
public class Balance {

    private double balance = 0;// default 0 dollars

    private static Balance firstInstance = null;

    private Balance(){

    }

    // makes only one instance of the class
    public static Balance getBalanceInstance(){
        if(firstInstance == null){
            firstInstance = new Balance();
        }
        return firstInstance;
    }
    public void depositMoney(double cash){
        //deposits money
        this.balance += cash;

    }

    public double getBalance(){
        //calls balance
        return this.balance;
    }


    public void subtractFromBalance(double cash){
        this.balance -= cash;
        //subtract from balance

    }

    public double getChange(){
        double changeBalance = this.balance;
        this.balance = 0;
        return changeBalance;
        //set change amount and reset balance to zero
    }



}
