package org.yearup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransactionFile transactionFile = new TransactionFile("transactions.csv");
        ArrayList<Transaction> transactions = transactionFile.readTransactions();

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

                    switch (ledgerSelection) {
                        case "A":
                            Collections.reverse(transactions);
                            for (Transaction t : transactions) {
                                System.out.println(t);
                            }
                            break;
                        case "D":
                            Collections.reverse(transactions);
                            for (Transaction t : transactions) {
                                if (t.getAmount() > 0) {
                                    System.out.println(t);
                                }
                            }
                            break;
                        case "P":
                            Collections.reverse(transactions);
                            for (Transaction t : transactions) {
                                if (t.getAmount() < 0) {
                                    System.out.println(t);
                                }
                            }
                            break;
                        case "R":
                            System.out.println("Please choose a report option:");
                            System.out.println("1) Month To Date");
                            System.out.println("2) Previous Month");
                            System.out.println("3) Year To Date");
                            System.out.println("4) Previous Year");
                            System.out.println("5) Search by Vendor");
                            System.out.println("0) Back");
                            String reportSelection = scanner.nextLine();

                            switch (reportSelection) {
                                case "1":
                                    LocalDate now = LocalDate.now();
                                    LocalDate startOfMonth = LocalDate.of(now.getYear(), now.getMonthValue(), 1);
                                    String Date = null;
                                    Date = null;
                                    for (Transaction t : transactions) {
                                        if (t.getDate().equalsIgnoreCase(Date)) {
                                            System.out.println(t);
                                        }
                                    }
                                    break;
                                case "2":
                                    LocalDate lastMonth = LocalDate.now().minusMonths(1);
                                    LocalDate startOfLastMonth = LocalDate.of(lastMonth.getYear(), lastMonth.getMonthValue(), 1);
                                    LocalDate endOfLastMonth = startOfMonth.minusDays(1);
                                    for (Transaction t : transactions) {
                                        if (!t.getDate().equalsIgnoreCase(Date)) {
                                            continue;
                                        }
                                        if (t.getDate().equalsIgnoreCase(Date)) {
                                            System.out.println(t);
                                        } else if (t.getDate().equals(endOfLastMonth)) {
                                            System.out.println(t);
                                        }
                                    }
                                    break;
                                case "3":
                                    LocalDate startOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
                                    for (Transaction t : transactions) {
                                        if (t.getDate().equalsIgnoreCase(Date)) System.out.println(t);
                                        else {
                                            if (t.getDate().equals(startOfYear)) {
                                                System.out.println(t);
                                            }
                                        }


                                    }
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + reportSelection);
                            }
                      }
            }

        }
    }
}