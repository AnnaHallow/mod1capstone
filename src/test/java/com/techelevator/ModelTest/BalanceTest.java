package com.techelevator.ModelTest;

import com.techelevator.Model.Balance;
import org.junit.Assert;
import org.junit.Test;

public class BalanceTest {

    @Test
    public void depositMoneyTest(){
        Balance newBalance = Balance.getBalanceInstance();
        newBalance.depositMoney(1);
        Assert.assertEquals(1.0 , newBalance.getBalance(), .001);
        newBalance.depositMoney(10);
        Assert.assertEquals(11.0, newBalance.getBalance(), .001);
        newBalance.depositMoney(20);
        Assert.assertEquals(31.0, newBalance.getBalance(), .001);
        newBalance.depositMoney(5);
        Assert.assertEquals(36.0, newBalance.getBalance(), .001);
    }

    @Test
    public void subtractFromBalanceTest(){
        Balance newBalance = Balance.getBalanceInstance();
        newBalance.subtractFromBalance(10);
        Assert.assertEquals(26 , newBalance.getBalance(), .001);
        newBalance.subtractFromBalance(14);
        Assert.assertEquals(12, newBalance.getBalance(), .001);
        newBalance.subtractFromBalance(5);
        Assert.assertEquals(7, newBalance.getBalance(), .001);
    }


}
