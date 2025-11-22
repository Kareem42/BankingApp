// child class - inheritance

public class SavingAccount extends Account {
    protected double balance;
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
    public double getBalance() {return 7500.00;}

    @Override
    public void getDeposit(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a positive amount");
        } else {
            balance += amount;
            System.out.println("Deposited $" + amount + " in savings account #" + getAccountNumber()
                    + " and your new balance is " + (getBalance() + amount));
        }
    }

    @Override
    public void getWithdraw(double amount) {
        if (amount > 0 && (balance - amount) <= balance) {
            balance -= amount;
            System.out.println("Withdrawing " + amount + " in savings account #" + getAccountNumber() +
                    " and your new balance is " + (getBalance() - amount));
        } else {
            System.out.println("Amount to withdraw is over the $300 limit per transaction. " +
                    "Please enter an amount that does not exceed $300.");
        }
    }

    public void depositToString() {
    }
    public void withdrawToString() {
    }
}
