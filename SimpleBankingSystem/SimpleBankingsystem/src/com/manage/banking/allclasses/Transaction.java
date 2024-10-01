//Name: Isha Bhatta
//Student Id:2408180
package com.manage.banking.allclasses;

public class Transaction {
    //Method to transfer a specified amount from one account to another
    public void transfer(Account from, Account to, int amount) {
        //check if the source account has enough balance
        if (from.getBalance() >= amount) {
            //withdraw amount
            from.withdraw(amount);
            //Deposit amount
            to.deposit(amount);
            //confirm the transfer with message
            System.out.println("Congratulations.Transfer is done successfully. The amount is Rs. " + from.getBalance()+".");
        }
    }
}

