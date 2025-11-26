import java.util.Scanner;
import java.util.InputMismatchException;

public class Communication {
    private CheckingAccount checkingAccount;
    private SavingAccount savingsAccount;

    public void presentOption() {
        String accountUser = "John Doe"; // considered as passing by value
        double balance = 300.00;
        int accountNumber = 2456;
        checkingAccount = new CheckingAccount(accountUser, accountNumber, balance);
        savingsAccount = new SavingAccount(accountUser, accountNumber, balance);
    }

    public void accountOptions() {
        // Get more understanding between passing by reference vs passing by value
        Scanner sc = new Scanner(System.in);
        presentOption();

        while (true) {
            try {
                System.out.println("Welcome to your Friendly Neighborhood Bank.");
                System.out.println("Select the account that you want to view: ");
                System.out.println("1. Checking");
                System.out.println("2. Savings");
                System.out.println("3. Exit");
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
                System.out.println("Invalid choice. Try again");
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
                double savingsBalance = account.getBalance();
                System.out.println("Your balance in your " + account.getAccountType() + " is $" + savingsBalance);
                break;
            case 2:
                System.out.print("How much do you want to deposit into your " + account.getAccountType() + ":");
                double depositAmount = sc.nextDouble();
                account.Deposit(depositAmount);
                break;
            case 3:
                System.out.print("How much do you want to withdraw from your" + account.getAccountType() + ":");
                double withdrawAmount = sc.nextDouble();
                account.Withdraw(withdrawAmount);
                break;
            default:
                System.out.println("Invalid choice. Try again");
                break;
        }
    }
}

//    public Account doSomething(Scanner sc) {
//        System.out.println("Welcome to your Friendly Neighborhood Bank.");
//        System.out.println("Select the account that you want to view: ");
//        System.out.println("1. Checking");
//        System.out.println("2. Savings");
//        System.out.print("Enter your option: ");
//
//        int choice = sc.nextInt();
//        return (choice == 1) ? checkingAccount:savingsAccount;
//    }
//
//
//    public void handleDeposit(Scanner sc) {
//        System.out.print("How much do you want to deposit into your account:");
//        double depositAmount = sc.nextDouble();
//        depositAmount.Deposit(depositAmount);
//        Account deposit = doSomething(sc);
//        deposit.Deposit(depositAmount);
//    }
//
//    public void handleWithdraw( Scanner sc) {
//        System.out.print("How much do you want to withdraw from your account:");
//        double withdrawAmount = sc.nextDouble();
//        doSomething(sc).Withdraw(withdrawAmount);
//    }




//                System.out.println("Welcome, " + checkingAccount.getOwnerName() + ", to your Friendly Neighborhood Bank!");
//                System.out.println("What would you like to do today?");
//                System.out.println("=============================");
//                System.out.println("1. Check Balance");
//                System.out.println("2. Deposit Money");
//                System.out.println("3. Withdraw Money");
//                System.out.println("4. Exit");
//                System.out.print("Enter your choice: ");

//                int choice = sc.nextInt();
//
//                switch (choice) {
//                    case 1:
//                        accountType(choice, sc);
//                        System.out.println("Your current balance in account #" + checkingAccount.getAccountNumber() +
//                                " is $" + checkingAccount.getBalance());
//                        if (choice == 2) {
//                            accountType(choice, sc);
//                            System.out.println("Your current balance in account #" + savingsAccount.getAccountNumber() +
//                                    " is $" + savingsAccount.getBalance());
//                        }
//                        continue;
//                    case 2:
//                        accountType(choice,sc);
//                        activeAccount.getDeposit();
//                        continue;
//                    case 3:
//                        accountType(choice,sc);
//                        activeAccount.getWithdraw();
//                        continue;
//                    case 4:
//                        System.out.println("Thank you, " + checkingAccount.getOwnerName() +
//                                ", for using our Friendly Neighborhood Bank!");
//                }
//                break;

//            sc.close();



//    public void accountType(int accountAction, Scanner input) {
//        System.out.println("Select the account that you want to view: ");
//        System.out.println("1. Checking");
//        System.out.println("2. Savings");
//        System.out.print("Enter your option: ");
//
//        int choice = input.nextInt();
//
//        switch (accountAction) {
//            case 2:
//                System.out.print("Enter amount to deposit: ");
//                double deposit = input.nextDouble();
//                if (choice == 1) {
//                    checkingAccount.Deposit(deposit);
//                } else if (choice == 2) {
//                    savingsAccount.getDeposit(deposit);
//                }
//                break;
//            case 3:
//                System.out.print("Enter amount to withdraw: ");
//                double withdraw = input.nextDouble();
//                if (choice == 1) {
//                    checkingAccount.getWithdraw(withdraw);
//                } else if (choice == 2) {
//                    savingsAccount.getWithdraw(withdraw);
//                } else {
//                    System.out.println("Invalid input. Try again");
//                }
//        }
//    }
//}



