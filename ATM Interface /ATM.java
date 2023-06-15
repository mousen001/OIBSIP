package com.oasis.infobyte;

import java.util.Scanner;

public class ATM
{
	private Bank bank;
    private Scanner scanner;

    public ATM() 
    {
        this.bank = new Bank();
        this.scanner = new Scanner(System.in);
    }

    public boolean login() 
    {
        System.out.print("User ID: ");
        String userID = scanner.nextLine();
        System.out.print("User PIN: ");
        String userPIN = scanner.nextLine();
        return bank.authenticateUser(userID, userPIN);
    }

    public void TransactionHistory() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.println("Transaction History of " + currentUser.getFullName() + ":");
        for (String transaction : currentUser.getTransactionHistory()) 
        {
            System.out.println(transaction);
        }
    }

    public void Withdraw() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.print("Enter the amount you want to withdraw : ");
        double amount = scanner.nextDouble();
        if (currentUser.withdraw(amount)) 
        {
            System.out.println("Rs. "+amount+" successfully withdrawal from your account.");
            System.out.println("Current Balance is : Rs." + String.format("%.2f", currentUser.getAccountBalance()));
        } 
        else 
        {
            System.out.println("Insufficient Amount !");
        }
    }

    public void Deposit() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.print("Enter the amount you want to deposit : ");
        double amount = scanner.nextDouble();
        currentUser.deposit(amount);
        System.out.println("Rs. "+amount+" successfully deposited to your account.");
        System.out.println("Current balance : Rs." + String.format("%.2f", currentUser.getAccountBalance()));
    }

    public void Transfer() 
    {

        User currentUser = bank.getCurrentUser();

        System.out.print("Enter the Recipent ID : ");
        String recipientID = scanner.next();
        User recipient = bank.getUserByID(recipientID);
        if (recipient == null) 
        {
            System.out.println("Invalid Recipent ID !");
            return;
        }
        System.out.print("Enter the amount you want to transfer : ");
        double amount = scanner.nextDouble();

        if (currentUser.transfer(amount, recipient)) 
        {
            System.out.println("Rs. "+amount+" sucessfully transferred to "+recipient.getFirstName());
            System.out.println("Current balance : Rs." + String.format("%.2f", currentUser.getAccountBalance()));
        } 
        
        else 
        {
            System.out.println("Insufficient Amount !");
        }

    }
    public void CheckBalance() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.println("Current balance : Rs." + String.format("%.2f", currentUser.getAccountBalance())); 
    }
}
