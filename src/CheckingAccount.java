// Child class - Inheritance

public class CheckingAccount extends Account {
    protected double balance;
    private int accountNumber;

    public CheckingAccount() {}

    public CheckingAccount(String ownerName, int accountNumber, double balance) {
        super(ownerName, accountNumber, balance);
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return 2546;
    }

    @Override
    public double getBalance() {
        return 3500.00;
    }

    @Override
    public void getDeposit(double amount) {
        if (amount > balance) {
            balance += amount;
            System.out.println("Deposited " + amount + " in checking account #" + getAccountNumber()
            + " and your new balance is " + (getBalance() + amount));
        } else {
            System.out.println("Please enter an amount that is greater than 0.");
        }
    }

    @Override
    public void getWithdraw(double amount) {
        if (amount > 0 && (balance - amount) <= balance) {
            balance -= amount;
            System.out.println("Withdrawing " + amount + " in checking account #" + getAccountNumber() +
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
