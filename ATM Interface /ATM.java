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
        System.out.print("USER ID: ");
        String userID = scanner.nextLine();
        System.out.print("USER PIN: ");
        String userPIN = scanner.nextLine();
        return bank.authenticateUser(userID, userPIN);
    }

    public void TransactionHistory() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.println("TRANSACTION HISTORY OF " + currentUser.getFullName() + ":");
        for (String transaction : currentUser.getTransactionHistory()) 
        {
            System.out.println(transaction);
        }
    }

    public void Withdraw() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.print("ENTER THE AMOUNT YOU WANT TO WITHDRAW : ");
        double amount = scanner.nextDouble();
        if (currentUser.withdraw(amount)) 
        {
            System.out.println("AMOUNT "+amount+" SUCESFULLY WITHDREWL FROM YOUR ACCOUNT");
            System.out.println("CURRENT BALANCE : RS." + String.format("%.2f", currentUser.getAccountBalance()));
        } 
        else 
        {
            System.out.println("INSUFFICIENT AMMOUNT !");
        }
    }

    public void Deposit() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.print("ENTER THE AMOUNT YOU WANT TO DEPOSIT : ");
        double amount = scanner.nextDouble();
        currentUser.deposit(amount);
        System.out.println("AMOUNT "+amount+" SUCESFULLY DEPOSITED TO YOUR ACCOUNT");
        System.out.println("CURRENT BALANCE : RS." + String.format("%.2f", currentUser.getAccountBalance()));
    }

    public void Transfer() 
    {

        User currentUser = bank.getCurrentUser();

        System.out.println("ENTER THE RECIPENT ID : ");
        String recipientID = scanner.nextLine();
        User recipient = bank.getUserByID(recipientID);
        if (recipient == null) 
        {
            System.out.println("INVALID RECIPENT ID !");
            return;
        }
        System.out.println("ENTER THE AMOUNT YOU WANT TO TRANSFER : ");
        double amount = scanner.nextDouble();

        if (currentUser.transfer(amount, recipient)) 
        {
            System.out.println("AMOUNT "+amount+" SUCESSFULLY TRANSFERED TO "+recipient.getFirstName());
            System.out.println("CURRENT BALANCE : RS." + String.format("%.2f", currentUser.getAccountBalance()));
        } 
        
        else 
        {
            System.out.println("INSUFFICIENT AMMOUNT !");
        }

    }
    public void CheckBalance() 
    {
        User currentUser = bank.getCurrentUser();
        System.out.println("CURRENT BALANCE : RS." + String.format("%.2f", currentUser.getAccountBalance())); 
    }
}
