//Name: Isha Bhatta
//Student Id:2408180
package com.manage.banking.parts;

import com.manage.banking.allclasses.Account;
import com.manage.banking.allclasses.Transaction;


public class Part1 {

    public static void main(String[] args) {
        // 1. Create an object from Account called account1
        Account account1 = new Account("Jeffrey", "Ting", 1, 2000);

        // 2. Create an object from Account called account2
        Account account2 = new Account("Hiran", "Patel", 2, 1000);

        // 3. Print out the balance of account1
        System.out.println("Balance of account1: " + account1.getBalance());

        // 4. Print out the balance of account2
        System.out.println("Balance of account2: " + account2.getBalance());

        // 5. Call the deposit function on the account1 object and deposit 250
        account1.deposit(250);

        // 6. Print out the balance of account1 – does it print out 2250?
        System.out.println("Balance of account1 after deposit: " + account1.getBalance());

        // 7. Call the withdraw function on the account2 object and withdraw 500
        account2.withdraw(500);

        // 8. Print out the balance of account2 – does it print out 500?
        System.out.println("Balance of account2 after withdrawal: " + account2.getBalance());

        // 9. Create an object called “t” from the Transaction class
        Transaction t = new Transaction();

        // 10. Call the transfer method using “t” and add account1 as parameter 1, account2 as parameter 2 and for the amount, set it to 250
        t.transfer(account1, account2, 250);

        // 11. Print out balance of account1
        System.out.println("Balance of account1 after transfer: " + account1.getBalance());

        // 12. Print out balance of account2
        System.out.println("Balance of account2 after transfer: " + account2.getBalance());

        // Final balances:
        // account1 should have 2000
        // account2 should have 750
    }
}


