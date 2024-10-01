package com.manage.banking.parts;

import com.manage.banking.allclasses.Transaction;
import com.manage.banking.allclasses.Account;
import com.manage.banking.allclasses.ReadAccounts;

import java.util.LinkedList;

public class Part2 {
    public static void main(String[] args) {
        try {
            LinkedList<Account> accounts = new LinkedList<>(); // List to store Account objects

            String file = "resources/account.csv"; // Path to the CSV file containing account data
            ReadAccounts readAccounts = new ReadAccounts(file); // Initialize ReadAccounts with the file path

            // Read the first names, last names, account numbers, and balances from the file
            LinkedList<String> firstNames = readAccounts.getFirstNames();
            LinkedList<String> lastNames = readAccounts.getLastNames();
            LinkedList<Integer> accountList = readAccounts.getAccounts();
            LinkedList<Integer> balanceList = readAccounts.getBalances();

            int i = 0;
            // Loop through the data to create Account objects and add them to the accounts list
            while (i < firstNames.size()) {
                String firstName = firstNames.get(i);
                String lastName = lastNames.get(i);
                int accountNumber = accountList.get(i);
                int balance = balanceList.get(i);

                Account account = new Account(firstName, lastName, accountNumber, balance); // Create an Account object

                accounts.add(account); // Add the account to the accounts list
                i++;
            }

            i = 0;
            // Loop through the accounts list to print out details of each account
            while (i < lastNames.size()) {
                System.out.println("FirstName: " + accounts.get(i).getFirstName() +
                        ", LastName: " + accounts.get(i).getLastName() +
                        ", Account Number: " + accounts.get(i).getAccountNum() +
                        ", Balance: " + accounts.get(i).getBalance());
                System.out.println(); // Print a blank line for better readability
                i++;
            }

            // Perform a deposit operation on the second account in the list
            Account secAcc = accounts.get(1);
            secAcc.deposit(30225);
            System.out.println();

            // Perform a withdrawal operation on the third account in the list
            Account thiAcc = accounts.get(2);
            thiAcc.withdraw(20256);

            // Create a Transaction object to facilitate a money transfer
            Transaction transfer = new Transaction();

            // Transfer an amount from the third account to the second account
            transfer.transfer(accounts.get(2), accounts.get(1), 3265);

        } catch (Exception e) {
            // Print any exceptions that occur during the execution of the program
            System.out.println(e.getMessage());
        }
    }
}
