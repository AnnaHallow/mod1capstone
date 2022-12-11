package com.techelevator.Model;


/**
 * <h1>Transaction</h1>
 * This class handle the balance of the vending machine
 *
 * <p>
 * <b>Note:</b> to create an instance of this class write
 * Transaction newTransaction = Transaction.getInstance();
 *
 * @author
 * @version 1.0
 * @since   2022-12-10
 */
public class Transaction {

    private double balance;

    private static Transaction firstInstance = null;

    private Transaction(){

    }

    // makes only one instance of the class
    public static Transaction getTransactionInstance(){
        if(firstInstance == null){
            firstInstance = new Transaction();
        }
        return firstInstance;
    }
    public void depositMoney(){

    }

    public double getBalance(){

        return 0;
    }

    public void subtractFromBalance(){

    }



}
