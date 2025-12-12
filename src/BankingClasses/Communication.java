package BankingClasses;

import java.util.*;

/* Get more understanding between passing by reference vs passing by value
        - Add option to create an account and log in.
        - To log in, you must enter your account number.
        - To create a new account, the user will need their name and the application will generate a random account number.
        - All new accounts balance will start at $5.00
        */


public class Communication {
    private CheckingAccount checkingAccount;
    private SavingAccount savingsAccount;

    private final Account[] account = new Account[10];

    public final Account[] existingUser1 = { new CheckingAccount("Dennis", 5.00, 1234),
            new SavingAccount("Dennis", 5.00, 5678) };
    public final Account[] existingUser2 = { new CheckingAccount("Justin", 5.00, 1456),
            new SavingAccount("Justin", 5.00, 4356) };


    public void accountOptions() {
        Scanner sc = new Scanner(System.in);
        account[0] = new CheckingAccount("Dennis", 5.00, 1234);
        account[1] = new SavingAccount("Dennis", 5.00, 5678);


        checkingAccount = (CheckingAccount) account[0];
        savingsAccount = (SavingAccount) account[1];

        logIn(sc, account);
        newCustomer(sc, checkingAccount);
        while (true) {
            try {
                System.out.println("Select the account that you want to view: ");
                System.out.println("1. Checking");
                System.out.println("2. Savings");
                System.out.println("3. Logout");
                System.out.print("Enter your option: ");

                int choice = sc.nextInt();
                if (choice == 3) {
                    System.out.println("Thank you for using our Friendly Neighborhood Bank");
                    break;
                }
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid option");
                    continue;
                }

                Account selectedAcount = null;
                if (choice == 1) {
                    selectedAcount = checkingAccount;
                } else {
                    selectedAcount = savingsAccount;
                }

                accountActions(sc, selectedAcount);

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
                System.out.println("Your balance in your " + account.getAccountType() +  account.getAccountNumber()
                        + " is $" + accountBalance);
                break;
            case 2:
                try {
                    System.out.print("How much do you want to deposit into your " + account.getAccountType()
                            + account.getAccountNumber() + ": ");
                    double depositAmount = sc.nextDouble();
                    account.Deposit(depositAmount);
                    System.out.println("You have deposited $" + depositAmount + " into " + account.getAccountType()
                            + account.getAccountNumber() + ". Your current balance is $" + account.getBalance());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3: {
                try {
                    System.out.print("How much do you want to deposit into your " + account.getAccountType()
                            + account.getAccountNumber() + ": ");
                    double withdrawAmount = sc.nextDouble();
                    account.Withdraw(withdrawAmount);
                    System.out.println("You have withdrawn $" + withdrawAmount + " into " + account.getAccountType()
                            + account.getAccountNumber() + ". Your current balance is $" + account.getBalance());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            break;

            default:
                System.out.println("Invalid choice. Try again");
                break;
        }
    }

    public void newCustomer(Scanner sc, Account accounts) {

        /* This method will handle the sign-up logic for new users.
         Need to figure out how to store the generated account number as the actual account number
         for either checking or savings account.
        */
        System.out.println("Welcome new user! Please select which account you would like to create: ");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        System.out.print("Enter your name: ");
        String name = sc.next();
        int newAccountNumber = accounts.getAccountNumber();

        accounts.setOwnerName(name);
        if (choice == 1) {
            System.out.println("Welcome, " + name + ". Your new checking account number is: "
                    + newAccountNumber);
        } else {
            System.out.println("Welcome, " + name + ". Your new savings account number is: "
                    + newAccountNumber);
        }
        accountActions(sc, accounts);
    }

    public void logIn(Scanner sc, Account[] users) {

        // This method will handle the log in for all users
        // Console console = System.console();

        System.out.println("Welcome to your Friendly Neighborhood Bank.");
        System.out.println("Are you a new user?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
//                newCustomer(sc, users);
                break;
            case 2: {
                try {
                    int attempts = 0;
                    boolean loggedIn = false;
                    CheckingAccount foundChekingAccount = null;
                    SavingAccount foundSavingAccount = null;

                    while (attempts < 3 && !loggedIn) {
                        attempts++;
                        System.out.print("Please enter your name: ");
                        String name = sc.next();
                        System.out.print("Please enter your 4 digit pin number: ");
                        int userPin = sc.nextInt();
                        // console.readPassword();

                        for (Account user : users) {
                            if (user != null) {
                                String userName = user.getOwnerName();
                                int pinNumber = user.getAccountNumber();

                                if ((userPin == pinNumber) && name.equals(userName)) {
                                    if (user instanceof SavingAccount) {
                                        foundSavingAccount = (SavingAccount) user;
                                    } else if (user instanceof CheckingAccount) {
                                        foundChekingAccount = (CheckingAccount) user;
                                    }
                                    loggedIn = true;
                                }
                            }
                        }

                        if (loggedIn) {
                            this.checkingAccount = foundChekingAccount;
                            this.savingsAccount = foundSavingAccount;
                            System.out.println("Successfully logged in! Welcome back, " + name + "!");
                        }
                    }
                    if (attempts == 3 && !loggedIn) {
                        System.out.println("Maximum attempts reached");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again" + e.getMessage());
                    sc.nextLine();
                }
            }
        }
    }
}