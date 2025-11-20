// child

public class SavingAccount extends Account {
    private double balance;
    private int accountNumber;

    public SavingAccount() {}

    public SavingAccount(String ownerName, int accountNumber, double balance) {
        super(ownerName, accountNumber, balance);
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public int getAccountNumber() {
        return 1425;
    }

    @Override
    public void getWithdraw() {
        getBalance();
    }

    @Override
    public void getDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " in checking account #" + accountNumber
            + " your new balance is: " + balance);
        } else  {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void getWithdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 0) {
            balance -= amount;
            System.out.println("Withdrawing " + amount + " in checking account #" + accountNumber +
                    " your new balance is: " + balance);
        } else   {
            System.out.println("Insufficient funds");
        }
    }

    public void depositToString() {
    }
    public void withdrawToString() {
    }
}
