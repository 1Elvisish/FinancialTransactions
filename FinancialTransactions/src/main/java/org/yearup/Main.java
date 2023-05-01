package org.yearup;

import java.util.ArrayList;
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
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
        }

    }
}
