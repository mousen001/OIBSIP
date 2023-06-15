package com.oasis.infobyte;

import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("		Welcome to SBI Bank ATM Service 		\n");

        ATM atm = new ATM();

        while (true) 
        {
            if (atm.login()) 
            {
                while (true) 
                {

                    System.out.println("1. View Transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer Money");
                    System.out.println("5. Check Balance");
                    System.out.println("6. Quit");
                    System.out.print("Enter your choice: ");

                    int choice = scanner.nextInt();

                    switch (choice) 
                    {
                        case 1:
                            atm.TransactionHistory();
                            break;
                        case 2:
                            atm.Withdraw();
                            break;
                        case 3:
                            atm.Deposit();
                            break;
                        case 4:
                            atm.Transfer();
                            break;
                        case 5:
                            atm.CheckBalance();
                            break;
                        case 6:
                            System.out.println("\nThank You, Visit Again ! ");
                            return;
                        default:
                            System.out.println("Please enter a valid input.");
                            break;
                    }
                }
            }
            else 
            {
                System.out.println("Invalid User ID or User PIN! Please enter correct details.");
            }
            scanner.close();
        }

    }

}
