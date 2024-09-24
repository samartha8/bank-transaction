package Coursework;

public class Transaction {
    // Method to transfer funds from sourceAccount to destinationAccount
    public void transfer(Account sourceAccount, Account destinationAccount, int amount) {
        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
            System.out.println("Transfer successful: $" + amount + " transferred from Account " + sourceAccount.getAccountNumber() + " to Account " + destinationAccount.getAccountNumber());
        } else {
            System.out.println("Failed to transfer: Insufficient Balance");
        }
    }
}
