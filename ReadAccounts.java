package Coursework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {
    public String url;

    // Constructor to set the file URL
    public ReadAccounts(String url) {
        this.url = url;
    }

    // Method to extract and return a list of first names from the file
    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) { // Ensure there are at least 2 values (first name and last name)
                    String firstName = values[0]; // Extract the first element as the first name
                    firstNames.add(firstName);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return firstNames;
    }

    // Method to extract and return a list of last names from the file
    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) { // Ensure there are at least 2 values (first name and last name)
                    String lastName = values[1]; // Extract the second element as the last name
                    lastNames.add(lastName);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return lastNames;
    }

    // Method to extract and return a list of account numbers from the file
    public LinkedList<Integer> getAccounts() {
        LinkedList<Integer> accounts = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    try {
                        int accountNumber = Integer.parseInt(values[2]);
                        accounts.add(accountNumber);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing account number: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return accounts;
    }

    // Method to extract and return a list of balances from the file
    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balances = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    try {
                        int balance = Integer.parseInt(values[3]);
                        balances.add(balance);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing balance: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return balances;
    }
}
