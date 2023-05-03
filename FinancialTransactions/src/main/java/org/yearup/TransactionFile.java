package org.yearup;

import java.io.*;
import java.util.ArrayList;

public class TransactionFile {
    private String filename;

    public TransactionFile(String filename) {
        this.filename = filename;
    }

    public ArrayList<Transaction> readTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 5) {
                    throw new IOException("Invalid line in transaction file: " + line);
                }
                String LocalDate = parts[0];
                String LocalTime = parts[1];
                String description = parts[2];
                String vendor = parts[3];
                double amount = Double.parseDouble(parts[4]);
                Transaction transaction = new Transaction(LocalDate, LocalTime, description, vendor, amount);
                transactions.add(transaction);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading transaction file: " + e.getMessage());
        }

        return transactions;
    }

    public void writeTransaction(Transaction transaction) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(transaction.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to transaction file: " + e.getMessage());
        }
    }

    public void write(ArrayList<Transaction> deposit) {
    }

    public void addTransaction(Transaction payment) {
    }

    public void saveTransactions(ArrayList<Transaction> transactions) {
    }
}

