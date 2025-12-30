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


    public void accountOptions() {
        Scanner sc = new Scanner(System.in);
//        accounts.add(new CheckingAccount("Dennis", 5.00, 2312, pin));
//        accounts.add(new SavingAccount("Dennis", 5.00, 5678, pin));

        User userLogIn = null;
        String result = "N";
        while (!Objects.equals(result, "Y")) {
            while (userLogIn == null) {
                userLogIn = logIn(sc);
            }
            while (userLogIn != null) {
                userLogIn = accountActions(sc, userLogIn);
            }

            System.out.println("Do you want to exit? Y or N");
            result = sc.next().toUpperCase();
        }
    }

    public User accountActions(Scanner sc, User user) {
        System.out.println("Which account would you like to view?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.print("Enter your option: ");
        int accountChoice = sc.nextInt();

        Account account = user.getUserAccountList().get(accountChoice - 1);


        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Logout");
        System.out.print("Enter your option: ");
        int actions = sc.nextInt();

        switch (actions) {
            case 1:
                double accountBalance = account.getBalance();
                System.out.println("Your balance in your " + account.getAccountType() + user.getAccountNumber()
                        + " is $" + accountBalance);
                break;
            case 2:
                try {
                    System.out.print("How much do you want to deposit into your " + account.getAccountType()
                            + user.getAccountNumber() + ": ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("You have deposited $" + depositAmount + " into " + account.getAccountType()
                            + user.getAccountNumber() + ". Your current balance is $" + account.getBalance());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3: {
                try {
                    System.out.print("How much do you want to deposit into your " + account.getAccountType()
                            + user.getAccountNumber() + ": ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("You have withdrawn $" + withdrawAmount + " from " + account.getAccountType()
                            + user.getAccountNumber() + ". Your current balance is $" + account.getBalance());
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

    public User newCustomer(Scanner sc) {
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

        System.out.print("Enter your 4 digit pin number: ");
        int pin = sc.nextInt();

        User userAccount = new User(name, pin, pin);
//        if (choice == 1) {
//            userAccount = new UserAccount(name, 5001, pin);
//            userAccount.setPinNumber(sc.nextInt());
//        } else {
//            userAccount = new UserAccount(name, 5000,  pin);
//            userAccount.setPinNumber(sc.nextInt());
//        }

        System.out.println(choice == 1 ? "Welcome, " + name + ". Your new checking account number is: "
                + userAccount.getAccountNumber() : "Welcome, " + name + ". Your new savings account number is: "
                + userAccount.getAccountNumber());

        accounts.add(userAccount);
        return userAccount;
//        accountActions(sc, accounts);
    }

    public User logIn(Scanner sc) {
        // This method will handle the log in for all users
        // List<Account> matchAccounts = new ArrayList<>();

        System.out.println("Welcome to your Friendly Neighborhood Bank.");
        System.out.println("Are you a new user?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
//               Account newUserAccount = newCustomer(sc);
                return newCustomer(sc);
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
                                String userName = userAccount.getUserId();
                                int pinNumber = userAccount.getPinNumber();

                                if ((userPin == pinNumber) && name.equals(userName)) {
                                    userAccount.getGreeting();
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
}