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

    private double balance;

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
    public double depositMoney(double cash){
        cash += balance;
        return balance;

    }

    public double getBalance(){

        return this.balance;
    }


    public double subtractFromBalance(double cash){
        balance -= cash;
        return balance;
    }

    public double getChange(){
        return balance;
    }



}
