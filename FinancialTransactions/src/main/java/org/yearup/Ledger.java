package org.yearup;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Ledger {
    private ArrayList<Transaction> transactions;

    public Ledger(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void displayAllEntries() {
        Collections.reverse(transactions);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void displayDeposits() {
        Collections.reverse(transactions);
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    public void displayPayments() {
        Collections.reverse(transactions);
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    public void runReport(String reportSelection) {
        switch (reportSelection) {
            case "1":
                LocalDate now = LocalDate.now();
                LocalDate startOfMonth = LocalDate.of(now.getYear(), now.getMonthValue(), 1);
                ChronoLocalDate endOfLastDate = null;
                ChronoLocalDate startOfLocalDate = null;
                for (Transaction t : transactions) {
                    if (t.getDate().isAfter(startOfLocalDate) && t.getDate().isBefore(endOfLastDate)) {
                        System.out.println(t);
                    }
                }
                break;
            case "2":
                LocalDate lastMonth = LocalDate.now().minusMonths(1);
                LocalDate startOfLastMonth = LocalDate.of(lastMonth.getYear(), lastMonth.getMonthValue(), 1);
                LocalDate endOfLastMonth = startOfLastMonth.plusMonths(1).minusDays(1);
                for (Transaction t : transactions) {
                    if (t.getDate().isAfter(startOfLastMonth) && t.getDate().isBefore(endOfLastMonth)) {
                        System.out.println(t);
                    }
                }
                break;
            case "3":
                LocalDate startOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
                ChronoLocalDate endOfYear = null;
                for (Transaction t : transactions) {
                    if (t.getDate().isAfter(startOfYear) && t.getDate().isBefore(endOfYear)) {
                        System.out.println(t);
                    } else if (t.getDate().equals(startOfYear)) {
                        System.out.println(t);
                    }
                }
                break;
            case "4":
                LocalDate lastYear = LocalDate.now().minusYears(1);
                LocalDate startOfLastYear = LocalDate.of(lastYear.getYear(), 1, 1);
                LocalDate endOfLastYear = startOfLastYear.plusYears(1).minusDays(1);
                for (Transaction t : transactions) {
                    if (t.getDate().isAfter(startOfLastYear) && t.getDate().isBefore(endOfLastYear)) {
                        System.out.println(t);
                    }
                }
                break;
            case "5":
                System.out.println("Please enter the vendor name:");
                String vendor = System.console().readLine();
                for (Transaction t : transactions) {
                    if (t.getVendor().equalsIgnoreCase(vendor)) {
                        System.out.println(t);
                    }
                }
                break;
            default:
                System.out.println("Invalid report option.");
        }
    }

    public void addTransaction(Transaction payment) {
    }
}
