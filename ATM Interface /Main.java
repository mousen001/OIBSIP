package com.oasis.infobyte;

import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("<--- WELCOME TO XYZ BANK ATM SERVICE --->\n");

        ATM atm = new ATM();

        while (true) 
        {
            if (atm.login()) 
            {
                while (true) 
                {

                    System.out.println("1. VIEW TRANSACTION HISTORY");
                    System.out.println("2. WITHDRAW");
                    System.out.println("3. DEPOSIT");
                    System.out.println("4. TRANSFER");
                    System.out.println("5. CHECK BALANCE");
                    System.out.println("6. QUIT");
                    System.out.print("ENTER YOUR CHOICE : ");

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
                            System.out.println("\nTHANK YOU FOR USING ATM SERVICE, VISIT AGAIN ! ");
                            return;
                        default:
                            System.out.println("WRONG INPUT, PLEASE ENTER A VALID INPUT");
                            break;
                    }
                }
            }
            else 
            {
                System.out.println("INVALID USER ID or USER PIN, PLEASE TRY AGAIN WITH CORRECT DETAILS");
            }
            scanner.close();
        }

    }

}
