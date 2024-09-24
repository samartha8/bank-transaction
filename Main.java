package Coursework;
import javax.swing.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        Account account1 = new Account("Jeffrey", "Ting", 1, 2000);
//        Account account2 = new Account("Hiran", "Patel", 2, 1000);
//
//        System.out.println("Initial Balance of Account 1: $" + account1.getBalance());
//        System.out.println("Initial Balance of Account 2: $" + account2.getBalance());
//
//        account1.deposit(250);
//        System.out.println("Balance of Account 1 after deposit: $" + account1.getBalance());
//
//        account2.withdraw(500);
//        System.out.println("Balance of Account 2 after withdrawal: $" + account2.getBalance());
//
//        Transaction t = new Transaction();
//
//        t.transfer(account1, account2, 250);
//
//        System.out.println("Final Balance of Account 1: $" + account1.getBalance());
//        System.out.println(" Final Balance of Account 2: $" + account2.getBalance());

        // Specify the file path containing account information
        String filePath = "Accounts.csv";
        ReadAccounts readAccounts = new ReadAccounts(filePath);

        // Create a linked list to store accounts
        LinkedList<Account> accounts = new LinkedList<>();

        // Extract account information from the file using ReadAccounts class
        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balanceList = readAccounts.getBalances();

        // Create Account objects and add them to the accounts list
        for(int i = 0; i < firstNames.size(); i++){
            accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
        }

        // Iterate through the accounts and perform operations
        for (Account account : accounts){
            System.out.println("Account Numbers: " + account.getAccountNumber());
            System.out.println("Name: " + account.getFirstName()+ " " + account.getLastName() );
            System.out.println("Balance: $" + account.getBalance());
            account.deposit(100);
            System.out.println("Balance after deposit: $" + account.getBalance());
            account.withdraw(50);
            System.out.println("Balance after withdrawal: $" + account.getBalance());
            System.out.println("----------------");
        }

        // Deposit additional funds into the first account
        accounts.get(0).deposit(100);

        // Create a Transaction object and perform a transfer
        Transaction t = new Transaction();
        t.transfer(accounts.get(0), accounts.get(1), 100);
        System.out.println("Final Balance of " + accounts.get(0).getFirstName()+" "+ accounts.get(0).getLastName()+": $" + accounts.get(0).getBalance());
        System.out.println("Final Balance of "+ accounts.get(1).getFirstName()+" "+ accounts.get(1).getLastName()+": $" + accounts.get(1).getBalance());

        // Create a new GUI object with the list of accounts
        GUI gui = new GUI(accounts);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the GUI visible
        gui.setVisible(true);
    }
}