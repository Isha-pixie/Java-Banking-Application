//Name: Isha Bhatta
//Student Id:2408180

package com.manage.banking.allclasses;
import com.manage.banking.allclasses.Customer;

public class Account extends Customer {

    private int balance;
    private int accountNumber;

    public Account(String FName, String LName, int accNum, int accBal) {
        setFirstName(FName);
        setLastName(LName);
        accountNumber = accNum;
        balance = accBal;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("The amount is Deposited. The amount is Rs. " + amount + " " + getFirstName() + " to " + getLastName()+".");
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.println("The amount is Withdrawed. The amount is Rs. " + amount + " " + getFirstName() + " to " + getLastName()+".");
    }
}
