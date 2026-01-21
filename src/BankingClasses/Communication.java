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
                                int pinNumber = userAccount.pin();

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
        User user = new User(firstName, lastName, userName, pin);
        UserOperations userOps = new UserOperations(user, pin, user.getUserOperations().getUserAccountList());

        user.setUserOperations(userOps);

//        // Checking for duplicate username
//        if (isUserNameValid(userName)) {
//            System.out.println("Username is already in use. Please try again");
//            return null;
//        }
        String accountType;
        int accountNumber = user.getAccountNumber();

        if (choice == 1) {
            userOps.createCheckingAccount(5.00);
            accountNumber = userOps.getCheckingAccountList().getFirst().getAccountNumber();
            accountType = "checking";
        } else {
            userOps.createSavingAccount(5.00);
            accountNumber = userOps.getSavingAccountList().getFirst().getAccountNumber();
            accountType = "checking";
        }

        System.out.printf("Welcome, %s! Your new %s account number is: %s%n",
                userName, accountType, accountNumber);

        // Storing the new created account (checking or savings)
        accounts.add(user);

        return user;
    }

    public User accountActions(Scanner sc, User user) {
        System.out.println("Which account would you like to view?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.print("Enter your option: ");
        int accountChoice = sc.nextInt();

        Account account = user.getUserOperations().getUserAccountList().get(accountChoice - 1);

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Logout");
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

//    // Method used to check for duplicate usernames to ensure that the username that's entered by the user is unique.
//    private boolean isUserNameValid(String userName) {
//        return accounts.stream()
//                .anyMatch(user -> user.getUserName().equalsIgnoreCase(userName));
//    }

    // Method to ensure that the user only has 2 options, which are checking or savings.
//    private int getValidChoice(Scanner sc) {
//        while (true) {
//            try {
//                int choice = sc.nextInt();
//                if (choice >= 1 && choice <= 2) {
//                    return choice;
//                }
//                System.out.println("Please choose either " + 1 + " and " + 2);
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Try again");
//                sc.next();
//            }
//        }
//    }

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