package com.oasis.infobyte;

import java.util.ArrayList;

public class User 
{

    private String userID;
    private String userPIN;
    private String firstName;
    private String lastName;
    private double accountBalance;
    private ArrayList<String> transactionHistory;

    public User(String userID, String userPIN, String firstName, String lastName, double initialBalance) 
    {
        this.userID = userID;
        this.userPIN = userPIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountBalance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String userPIN) 
    {
        return this.userPIN.equals(userPIN);
    }

    public boolean withdraw(double amount) 
    {
        if (amount > accountBalance) 
        {
            return false;
        } 
        else 
        {
            accountBalance -= amount;
            String transaction = "WITHDRAWAL AMMOUNT : -RS." + amount + " CURRENT BALANCE : RS." + accountBalance;
            transactionHistory.add(transaction);
            return true;
        }
    }

    public void deposit(double amount) 
    {
        accountBalance += amount;
        String transaction = "DEPOSITED AMMOUNT : +RS." + amount + " CURRENT BALANCE : RS." + accountBalance;
        transactionHistory.add(transaction);
    }

    public boolean transfer(double amount, User recipient) 
    {
        if (amount <= accountBalance) 
        {
            accountBalance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("TRANSFER AMOUNT RS." + amount + " TO " + recipient.getFirstName());
            return true;
        } 
        else 
        {
            return false;
        }
    }

    public String getUserID() 
    {
        return userID;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public double getAccountBalance() 
    {
        return accountBalance;
    }

    public ArrayList<String> getTransactionHistory() 
    {
        return transactionHistory;
    }

    public String getFullName() 
    {
        return firstName + " " + lastName;
    }
}
