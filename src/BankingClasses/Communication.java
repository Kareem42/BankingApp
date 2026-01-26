package BankingClasses;

import java.util.*;
/* Get more understanding between passing by reference vs passing by value
        - Add option to create an account and log in.
        - To log in, you must enter your account number.
        - To create a new account, the user will need their name and the application will generate a random account number.
        - All new accounts balance will start at $5.00
        */
public class Communication {
    private final List<User> accounts = new ArrayList<>();
    private final List<Account> createdAccountList = new ArrayList<>();

    public User signIn(Scanner sc) {
        System.out.println("Welcome to your Friendly Neighborhood Bank.");
        System.out.println("Are you a new user?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                return accountCreation(sc);
            case 2: {
                try {
                    int attempts = 0;

                    while (attempts <= 3) {
                        attempts++;
                        System.out.print("Please enter your name: ");
                        String name = sc.next();
                        System.out.print("Please enter your 4 digit pin number: ");
                        int userPin = sc.nextInt();

                        for (User userAccount : accounts) {
                            if (userAccount != null) {
                                String userName = String.valueOf(userAccount.getUserName());
                                int pinNumber = userAccount.getPin();

                                if ((userPin == pinNumber) && name.equals(userName)) {
                                    return userAccount;
                                }
                            }
                            return userAccount;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again" + e.getMessage());
                    sc.nextLine();
                }
            }
        }
        return null;
    }

    public User accountCreation(Scanner sc) {
        System.out.println("Welcome new user! Please select which account you would like to create: ");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        while (choice != 1 && choice != 2) {
            System.out.println("Invalid input. Try again");
            choice = sc.nextInt();
            sc.nextLine();
        }

        System.out.print("Enter a unique username: ");
        String userName = sc.nextLine().trim();

        System.out.print("Enter your first name: ");
        String firstName = sc.next().trim();

        System.out.print("Enter your last name: ");
        String lastName = sc.next().trim();

        System.out.print("Enter your 4 digit pin number: ");
        int pin = getValidPin(sc);

        // Creating a user and operations with an account type
        User userCreated = new User(firstName, lastName, userName, pin);
        UserOperations userOps = new UserOperations(userCreated, pin, createdAccountList);

        // Ensuring that the user can interact with their account once the account is created.
        userCreated.setUserOperations(userOps);

        String accountType;

        if (choice == 1) {
            userOps.createCheckingAccount(5.00);
            accountType = "checking";
        } else {
            userOps.createSavingAccount(5.00);
            accountType = "savings";
        }

        System.out.println("Welcome, " + userCreated.getUserName().toUpperCase() + " to your new " + accountType + " account.");

        // Storing the new created account (checking or savings)
        accounts.add(userCreated);

        return userCreated;
    }

    public User accountActions(Scanner sc, User user) {
        System.out.println("Which account would you like to view?");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Exit");
        System.out.print("Enter your option: ");
        int accountChoice = sc.nextInt();

        // Need to find a better way to handle the IndexOutOfBoundsException
        Account account = user.getUserOperations().getUserAccountList().get(accountChoice - 1);

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your option: ");
        int actions = sc.nextInt();

        switch (actions) {
            case 1:
                double accountBalance = account.getBalance();
                System.out.println("Your balance in your " + account.getAccountType() + account.getAccountNumber()
                        + " is $" + accountBalance);
                break;
            case 2:
                try {
                    System.out.print("How much do you want to deposit into your " + account.getAccountType()
                            + account.getAccountNumber() + ": ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);

                    System.out.println("You have deposited $" + depositAmount + " into " + account.getAccountType()
                            + account.getAccountNumber() + ". Your current balance is $" + account.getBalance());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3: {
                try {
                    System.out.print("How much do you want to withdraw from your " + account.getAccountType()
                            + account.getAccountNumber() + ": ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);

                    System.out.println("You have withdrawn $" + withdrawAmount + " from " + account.getAccountType()
                            + account.getAccountNumber() + ". Your current balance is $" + account.getBalance());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            break;
            case 4:
                return null;

            default:
                System.out.println("Invalid choice. Try again");
                break;
        }
        return user;
        }

    public void exitOptions() {
        Scanner sc = new Scanner(System.in);

        User userLogIn = null;
        String result = "N";
        while (!Objects.equals(result, "Y")) {
            while (userLogIn == null) {
                userLogIn = signIn(sc);
            }
            while (userLogIn != null) {
                userLogIn = accountActions(sc, userLogIn);
            }

            System.out.println("Do you want to exit? Y or N");
            result = sc.next().toUpperCase();
        }
        sc.close();
    }

    // Method to ensure the user will enter only numeric values ranging from 1000 to 9999. (No special characters or letters)
    private int getValidPin(Scanner sc) {
        while (true) {
            try {
                int pin = sc.nextInt();
                if (pin >= 1000 && pin <= 9999) {
                    return pin;
                }
                System.out.println("PIN must be 4 digits. Please try again");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a 4-digit number");
                sc.next();
            }
        }
    }
}