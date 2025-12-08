package BankingClasses;

import java.util.*;
import java.io.*;

public class Communication {
    private CheckingAccount checkingAccount;
    private SavingAccount savingsAccount;

    public void presentOption() {
        String accountUser = "John Doe"; // considered as passing by value
        double balance = 500.00;
        checkingAccount = new CheckingAccount(accountUser, balance);
        savingsAccount = new SavingAccount(accountUser, balance);
    }

    public void accountOptions() {
        Scanner sc = new Scanner(System.in);
        presentOption();

        /* Get more understanding between passing by reference vs passing by value
        - Add option to create an account and log in.
        - To log in, you must enter your account number.
        - To create a new account, the user will need their name and the application will generate a random account number.
        - All new accounts balance will start at $5.00
        */
        logIn(sc,checkingAccount);

        while (true) {
            try {
                System.out.println("Select the account that you want to view: ");
                System.out.println("1. Checking");
                System.out.println("2. Savings");
                System.out.println("3. Logout");
                System.out.print("Enter your option: ");

                int choice = sc.nextInt();
                if (choice == 3){
                    System.out.println("Thank you for using our Friendly Neighborhood Bank");
                    break;
                }
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid option");
                    continue;
                }

                Account account = (choice == 1) ? checkingAccount:savingsAccount;
                accountActions(sc, account);

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Try again" + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }

    public void accountActions(Scanner sc, Account account) {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.print("Enter your option: ");
        int actions = sc.nextInt();

        switch (actions) {
            case 1:
                double accountBalance = account.getBalance();
                System.out.println("Your balance in your " + account.getAccountType() + " is $" + accountBalance);
                break;
            case 2: {
                try {
                    System.out.print("How much do you want to deposit into your " + account.getAccountType()
                            + account.getAccountNumber() + ": ");
                    double depositAmount = sc.nextDouble();
                    account.Deposit(depositAmount);
                    System.out.println("Current balance in " + account.getAccountType() + " is $" + account.getBalance());
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again" + e.getMessage());
                }
                break;
            }
            case 3:
            {
                try {
                    System.out.print("How much do you want to deposit into your " + account.getAccountType()
                             + account.getAccountNumber() + ": ");
                    double withdrawAmount = sc.nextDouble();
                    account.Withdraw(withdrawAmount);
                    System.out.println("Current balance in " + account.getAccountType() + " is $" + account.getBalance());
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again" + e.getMessage());
                }
                break;
            }
            default:
                System.out.println("Invalid choice. Try again");
                break;
        }
    }

    public void newCustomer(Scanner sc, Account account) {
        /* This method will handle the sign-up logic for new users.
         Need to figure out how to store the generated account number as the actual account number
         for either checking or savings account.
        */
        System.out.println("Welcome new user! please select which account you would like to create: ");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        System.out.print("Enter your name: ");
        String name = sc.next();

        if (choice == 1) {


            System.out.println("Welcome, " + name + ". Your new checking account number is: "
                    + account.getGeneratedAccountNumber());
            accountActions(sc, checkingAccount);
        } else {
            System.out.println("Welcome, " + name + ". Your new savings account number is: "
                    + account.getGeneratedAccountNumber());
            accountActions(sc, savingsAccount);
        }
    }

    public void logIn(Scanner sc, Account account) {
        // This method will handle the log in for all users
        // Console console = System.console();

        int pinNumber = account.getAccountNumber();
        String userName = account.getOwnerName();
        int attempts = 0;
        boolean loggedIn = false;

        System.out.println(pinNumber);
        System.out.println("Welcome to your Friendly Neighborhood Bank.");
        System.out.println("Are you a new user?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                newCustomer(sc, account);
                break;
            case 2: {
                try {
                    while (attempts < 3 && !loggedIn) {
                        attempts++;
                        System.out.print("Please enter your name: ");
                        String name = sc.next();
                        System.out.print("Please enter your 4 digit pin number: ");
                        int userPin = sc.nextInt();
                        // console.readPassword();

                        if ((userPin == pinNumber) && name.equals(userName)) {
                            System.out.println("Successfully logged in! Welcome back!");
                            loggedIn = true;
                        } else {
                            System.out.println("Invalid input. Try again");
                        }
                    }

                    if (!loggedIn) {
                        System.out.println("Maximum attempts reached");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again" + e.getMessage());
                    sc.nextLine();
                }
                break;
            }
            default:
                System.out.println("Invalid choice. Try again");
        }
    }
}