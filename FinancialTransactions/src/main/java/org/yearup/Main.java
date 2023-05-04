package org.yearup;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransactionFile transactionFile = new TransactionFile("transactions.csv");
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        // code to add transactions to the list
        Transaction transaction1 = new Transaction(LocalDate.parse("2023-04-15"), LocalTime.parse("10:13:25"), "ergonomic keyboard", "Amazon", -89.50);
        Transaction transaction2 = new Transaction(LocalDate.parse("2023-04-15"), LocalTime.parse("11:15:00"), "Invoice 1001 paid", "Joe", 1500.00);

        transactions.add(transaction2);

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
                    System.out.println("Please enter the deposit information:");
                    System.out.print("Date (yyyy-MM-dd): ");
                    String date = scanner.nextLine();
                    System.out.print("Time (HH:mm:ss): ");
                    String time = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Vendor: ");
                    String vendor = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    Transaction deposit = new Transaction();
                    transactions.add(deposit);
                    transactionFile.saveTransactions(transactions);

                    System.out.println("Deposit added successfully.");
                    break;
                case "P":
                    // code to make a payment
                    // prompt user for payment information
                    System.out.println("Enter payment information:");
                    System.out.print("Date (YYYY-MM-DD): ");
                    String paymentDate = scanner.nextLine();
                    System.out.print("Time (HH:MM:SS): ");
                    String paymentTime = scanner.nextLine();
                    System.out.print("Description: ");
                    String paymentDescription = scanner.nextLine();
                    System.out.print("Vendor: ");
                    String paymentVendor = scanner.nextLine();
                    System.out.print("Amount: ");
                    double paymentAmount = Double.parseDouble(scanner.nextLine());

                    // create new transaction and add it to transactions list
                    Transaction paymentTransaction = new Transaction();
                    transactions.add(paymentTransaction);

                    // save updated transactions list to file
                    transactionFile.write(transactions);

                    System.out.println("Payment added.");
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
                            ledger.displayAllTransactions();
                            break;
                        case "D":
                            ledger.displayDeposits();
                            break;
                        case "P":
                            ledger.displayPayments();
                            break;
                        case "R":
                            ledger.displayReports();
                            break;
                        case "0":
                            break;
                        default:
                            System.out.println("Invalid selection.");
                    }
                    break;
                case "E":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid selection.");

            }


        }
    }
}

