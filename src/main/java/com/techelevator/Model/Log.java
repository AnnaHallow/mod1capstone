package com.techelevator.Model;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Log {

    public static void log(String operation, double amount, double balance) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        // Date formater
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/MM/uuuu");;
        String dateString = date.format(dateFormat);

        // Time formater
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh.mm.ss a");
        String timeString = time.truncatedTo(ChronoUnit.SECONDS).format(timeFormat);

        try (FileWriter fWriter = new FileWriter("src/main/java/com/techelevator/Log.txt", true);
             PrintWriter outputWriter = new PrintWriter(fWriter)){
            //outputWriter.println(date + " " + time + " " + operation + " $" + amount + " -> Total: $" + balance);
            //outputWriter.println(dateString + " " + timeString + " " + operation + " $" + amount + " $" + balance);
            outputWriter.printf("%s %s %s $%.2f $%.2f\n", dateString, timeString, operation, amount, balance);
        } catch (Exception e) {
            System.out.println("An error has occurred");
        }


    }
}
