import java.util.Scanner;
import java.util.InputMismatchException;

public class Communication {
    private CheckingAccount checkingAccount;
    private SavingAccount savingsAccount;

    public void presentOption() {

        // Need to fix console to actually switch between checking account or savings account
        // Possible solutions:
        // 1. Store the accounts as instance variables
        // 2. Create methods that handles Deposits and Withdraws between accounts
        String accountUser = "John Doe";
        double balance = 300.00;
        int accountNumber = 2456;
        checkingAccount = new CheckingAccount(accountUser, accountNumber, balance);
        savingsAccount = new SavingAccount(accountUser, accountNumber, balance);

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Select the account that you want to view: ");
                System.out.println("1. Checking");
                System.out.println("2. Savings");
                System.out.print("Enter your option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit Money");
                        System.out.println("3. Withdraw Money");
                        int action = sc.nextInt();
                        switch (action) {
                            case 1:
                                double checkingBalance = checkingAccount.getBalance();
                                System.out.println("Your checking balance is $" + checkingBalance);
                                break;
                            case 2:
                                System.out.println("How much do you want to deposit?");
                                double depositAmount = sc.nextDouble();
                                checkingAccount.Deposit(depositAmount);
                                System.out.println("case 2");
                                break;
                            case 3:
                                System.out.println("How much do you want to withdraw?");
                                double  withdrawAmount = sc.nextDouble();
                                checkingAccount.Withdraw(withdrawAmount);
                                System.out.println("case 3");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit Money");
                        System.out.println("3. Withdraw Money");
                        int savingActions = sc.nextInt();
                        switch (savingActions) {
                            case 1:
                                double checkingBalance = savingsAccount.getBalance();
                                System.out.println("Your savings balance is $" + checkingBalance);
                                break;
                            case 2:
                                System.out.println("How much do you want to deposit?");
                                double depositAmount = sc.nextDouble();
                                savingsAccount.Deposit(depositAmount);
                                System.out.println("case 2");
                                break;
                            case 3:
                                System.out.println("How much do you want to withdraw?");
                                double  withdrawAmount = sc.nextDouble();
                                savingsAccount.Withdraw(withdrawAmount);
                                System.out.println("case 3");
                                break;
                        }
                        break;
                }

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
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Try again");
            }
//            sc.close();
        }
    }
}

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



