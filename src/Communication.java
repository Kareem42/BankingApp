import java.util.Scanner;
import java.util.InputMismatchException;

public class Communication {
    public void presentOption() {
        Account activeAccount = new CheckingAccount();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Welcome, " + activeAccount.getOwnerName() + ", to your Friendly Neighborhood Bank!!!!");
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
                        accountType();
                        continue;
                        case 2:
                            accountType();
//                            activeAccount.getDeposit();
                            continue;
                            case 3:
                                accountType();
                                activeAccount.getWithdraw();
                                continue;
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Try again");
            }
        }
        sc.close();
    }

    public void accountType() {
        Account checkingAccount = new CheckingAccount();
        Account savingAccount = new SavingAccount();
        Scanner input = new Scanner(System.in);

        System.out.println("Select the account that you want to view: ");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.print("Enter your option: ");

        int choice = input.nextInt();

        // why doesn't continue work within this switch statement?
        // for loop will not work
        // while loop could work, possibly
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = input.nextDouble();
                    checkingAccount.getDeposit(deposit);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = input.nextDouble();
//                    checkingAccount.getWithdraw(withdraw);
                    break;
                default:
                    break;
            }
        }
//       input.close();
    }



