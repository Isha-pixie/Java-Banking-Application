//Name: Isha Bhatta
//Student Id: 2408180

package com.manage.banking.parts;

import com.manage.banking.allclasses.Account;
import com.manage.banking.allclasses.GUI;
import com.manage.banking.allclasses.ReadAccounts;

import javax.swing.*;
import java.util.LinkedList;

public class Part3 {
    public static void main(String[] args) {
        // Initialize ReadAccounts with the file path to read account data
        ReadAccounts readAccounts = new ReadAccounts("resources/account.csv");

        // Retrieve data from the CSV file: first names, last names, account numbers, and balances
        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountNumbers = readAccounts.getAccounts();
        LinkedList<Integer> balances = readAccounts.getBalances();

        // Create a list to hold Account objects
        LinkedList<Account> accounts = new LinkedList<>();
        int i = 0;

        // Loop through the data to create Account objects and add them to the list
        while (i < firstNames.size()) {
            String firstName = firstNames.get(i);
            String lastName = lastNames.get(i);
            int accountNumber = accountNumbers.get(i);
            int balance = balances.get(i);

            Account account = new Account(firstName, lastName, accountNumber, balance); // Create an Account object
            accounts.add(account); // Add the Account object to the list

            i++;
        }

        // Initialize the GUI with the list of accounts
        GUI gui = new GUI(accounts);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application closes properly
        gui.setSize(1000, 1000); // Set the size of the GUI window
        gui.setVisible(true); // Make the GUI visible to the user
    }
}
