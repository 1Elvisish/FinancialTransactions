package org.yearup;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.YearMonth;

public class Ledger {
    private ArrayList<Transaction> transactions;

    public Ledger(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void displayAllTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }

    public void displayDeposits() {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() >= 0) {
                System.out.println(transaction.toString());
            }
        }
    }

    public void displayPayments() {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction.toString());
            }
        }
    }

    public void displayReports() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose a report:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.println("H) Home");

            String reportSelection = scanner.nextLine();

            switch (reportSelection) {
                case "1":
                    displayMonthToDateReport();
                    break;
                case "2":
                    displayPreviousMonthReport();
                    break;
                case "3":
                    displayYearToDateReport();
                    break;
                case "4":
                    displayPreviousYearReport();
                    break;
                case "5":
                    displayVendorReport();
                    break;
                case "0":
                    return;
                case "H":
                    // Go back to the home page
                    System.out.println("Returning to home page...");
                    return;
                default:
                    System.out.println("Invalid selection.");

            }
        }
    }

    private void displayYearToDateReport() {
         {
             LocalDate now = LocalDate.now();
             LocalDate startOfYear = LocalDate.of(now.getYear(), 1, 1);
             double totalAmount = 0.0;

             System.out.println("Transactions for Year To Date:");

             for (Transaction transaction : transactions) {
                 LocalDate transactionDate = LocalDate.parse(transaction.getFormattedDate(), DateTimeFormatter.ISO_LOCAL_DATE);
                 if (!transactionDate.isBefore(startOfYear)) {
                     System.out.println(transaction.toString());
                     totalAmount += transaction.getAmount();
                 }
             }
            System.out.println("Total amount for Year To Date: " + totalAmount);
        }

    }

    private void displayMonthToDateReport() {
        LocalDate now = LocalDate.now();
        LocalDate startOfYear = LocalDate.of(now.getYear(), 1, 1);
        double totalAmount = 0.0;

        System.out.println("Transactions for Year To Date:");

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getFormattedDate(), DateTimeFormatter.ISO_LOCAL_DATE);
            if (!transactionDate.isBefore(startOfYear)) {
                System.out.println(transaction.toString());
                totalAmount += transaction.getAmount();
            }
        }

        System.out.println("Total amount for Year To Date: " + totalAmount);
    }

    private void displayPreviousMonthReport() {
        LocalDate now = LocalDate.now();
        LocalDate startOfMonth = LocalDate.of(now.getYear(), now.getMonth().minus(1), 1);
        LocalDate endOfMonth = YearMonth.of(now.getYear(), now.getMonth().minus(1)).atEndOfMonth();
        double totalAmount = 0.0;

        System.out.println("Transactions for Previous Month:");

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getFormattedDate());
            if (transactionDate.isAfter(startOfMonth) && transactionDate.isBefore(endOfMonth.plusDays(1))) {
                System.out.println(transaction.toString());
                totalAmount += transaction.getAmount();
            }
        }

        System.out.println("Total amount for Year To Date: " + totalAmount);
    }

    private void displayPreviousYearReport() {
        LocalDate now = LocalDate.now();
        LocalDate startOfYear = LocalDate.of(now.minusYears(1).getYear(), 1, 1); // Fixed here
        LocalDate endOfYear = LocalDate.of(now.minusYears(1).getYear(), 12, 31); // Fixed here
        double totalAmount = 0.0;

        System.out.println("Transactions for Previous Year:");

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getFormattedDate());
            if (transactionDate.isAfter(startOfYear.minusDays(1)) && transactionDate.isBefore(endOfYear.plusDays(1))) {
                System.out.println(transaction.toString());
                totalAmount += transaction.getAmount();
            }
        }

        System.out.println("Total amount for Previous Year: " + totalAmount);
    }


    private void displayVendorReport() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a vendor name:");
        String vendorName = scanner.nextLine();

        double totalAmount = 0.0;

        System.out.println("Transactions for Vendor: " + vendorName);

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.println(transaction.toString());
                totalAmount += transaction.getAmount();
            }
        }

        System.out.println("Total amount for Vendor " + vendorName + ": " + totalAmount);

        System.out.println("Press 0 to go back");
        while (true) {
            String selection = scanner.nextLine();
            if (selection.equals("0")) {
                return;
            }

        }
    }
}
