import java.util.Scanner;
import java.util.InputMismatchException;

public class Communication {
    public void presentOption() {
        // Need to fix console to actually switch between checking account or savings account
        // Possible solutions:
        // 1. Store the accounts as instance variables
        // 2. Create methods that handles Deposits and Withdraws between accounts
        Account activeAccount = new CheckingAccount();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Welcome, " + activeAccount.getOwnerName() + ", to your Friendly Neighborhood Bank!");
                System.out.println("What would you like to do today?");
                System.out.println("=============================");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        accountType(choice);
                        System.out.println("Your current balance in account #" + activeAccount.getAccountNumber() +
                                " is $" + activeAccount.getBalance());
                        continue;
                    case 2:
                        accountType(choice);
                        activeAccount.getDeposit();
                        continue;
                    case 3:
                        accountType(choice);
                        activeAccount.getWithdraw();
                        continue;
                    case 4:
                        System.out.println("Thank you, " + activeAccount.getOwnerName() +
                                ", for using our Friendly Neighborhood Bank!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Try again");
            }
        }
        sc.close();
    }

    public void accountType(int accountAction) {
        Account checkingAccount = new CheckingAccount();
        Account savingAccount = new SavingAccount();
        Scanner input = new Scanner(System.in);

        System.out.println("Select the account that you want to view: ");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.print("Enter your option: ");

        int choice = input.nextInt();

        switch (accountAction) {
            case 2:
                System.out.print("Enter amount to deposit: ");
                double deposit = input.nextDouble();
                if (choice == 1) {
                    checkingAccount.getDeposit(deposit);
                } else if (choice == 2) {
                    savingAccount.getDeposit(deposit);
                }
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdraw = input.nextDouble();
                if (choice == 1) {
                    checkingAccount.getWithdraw(withdraw);
                } else if (choice == 2) {
                    savingAccount.getWithdraw(withdraw);
                } else {
                    System.out.println("Invalid input. Try again");
                }
        }
    }
}



