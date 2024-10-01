//Name: Isha Bhatta
//Student Id:2408180
package com.manage.banking.allclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {

    public String url;  //holds file path of the account file
    public BufferedReader reader;  //buffered reader that we'll use to read the file

    //Constructor to initialize the file path
    public ReadAccounts(String url) {
        this.url = url;
    }

    //Method to retrieve the first names from the file
    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();//List to store the first names
        try {
            FileReader fileReader = new FileReader(url);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();// Read first line
            while (line != null) {  //continue reading until the end of the file
                String[] firstName = line.split(",");//split the lines by commas
                if (firstName.length > 0) {  //Ensure there is at least one element
                    String firstname = firstName[0].trim(); //Get and trim the first name
                    firstNames.add(firstname); //Add the first name to the list
                }
                line = reader.readLine(); //Read the next line
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());//Print any IO exceptions that occur
        }
        return firstNames;
    }

    //Method to retrieve the last names from the file
    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(url);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null) {
                String[] lastName = line.split(",");
                if (lastName.length > 1) {
                    String lastname = lastName[1].trim();
                    lastNames.add(lastname);
                }
                line = reader.readLine(); // Read the next line
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lastNames;
    }

    //Method to retrieve account numbers from the file
    public LinkedList<Integer> getAccounts() {
        LinkedList<Integer> accountList = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(url);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null) {
                String[] account = line.split(",");
                if (account.length > 2) {
                    String accNumber = account[2].trim();
                    int accountNumber = Integer.parseInt(accNumber);
                    accountList.add(accountNumber);
                }
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return accountList;
    }

    //Method to retrieve account balances from the file
    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balanceList = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(url);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null) {
                String[] balance = line.split(",");
                if (balance.length > 3) {
                    String balanceInAcc = balance[3].trim();
                    int balanceInt = Integer.parseInt(balanceInAcc);
                    balanceList.add(balanceInt);
                }
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return balanceList;
    }
}

