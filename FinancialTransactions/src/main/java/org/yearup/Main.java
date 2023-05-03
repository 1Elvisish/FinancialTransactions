package org.yearup;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransactionFile transactionFile = new TransactionFile("transactions.csv");
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
       // add transactions to the list

        Ledger ledger = new Ledger(transactions);


        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Please choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make A Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("E) Exit");
            System.out.println("Make a selection");




            String selection = scanner.nextLine().toUpperCase();
            switch (selection) {
                case "D":
                    // code to add deposit
                    break;
                case "P":
                    // code to make a payment
                    break;
                case "L":
                    System.out.println("Please choose an option:");
                    System.out.println("A) All");
                    System.out.println("D) Deposits");
                    System.out.println("P) Payments");
                    System.out.println("R) Reports");
                    System.out.println("0) Back");
                    String ledgerSelection = scanner.nextLine().toUpperCase();
            }
        }
    }
}

