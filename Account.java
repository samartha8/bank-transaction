package Coursework;

public class Account extends Customer {
    private int balance;
    private int accountNumber;

    // Constructor to initialize account details
    public Account(String FName, String LName, int accNum, int accBal) {
        setFirstName(FName);
        setLastName(LName);
        balance = accBal;
        accountNumber = accNum;
    }

    // Getter method to retrieve the account balance
    public int getBalance() {
        return balance;
    }

    // Getter method to retrieve the account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Method to deposit an amount into the account
    public void deposit(int amount) {
        balance += amount;
    }

    // Method to withdraw an amount from the account
    public void withdraw(int amount) {
        balance -= amount;
    }
}