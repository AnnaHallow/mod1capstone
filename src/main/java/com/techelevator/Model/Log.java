package com.techelevator.Model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Log {


    public static void log(String operation, double amount, double balance) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        try {
            PrintWriter transactionLog = new PrintWriter("src/main/java/com/techelevator/Log.txt");
            transactionLog.println(date + " " + time + " " + operation + " $" + amount + "$" + balance);
        } catch (Exception e) {
            System.out.println("An error has occurred");
        }


    }
}
