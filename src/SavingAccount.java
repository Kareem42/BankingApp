// child class - inheritance

public class SavingAccount extends Account {
    public SavingAccount(String ownerName, int accountNumber, double balance) {
        super(ownerName, accountNumber, balance);
    }

    @Override
    public void Deposit(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a positive amount");
        } else {
            balance += amount;
            System.out.println("Deposited $" + amount + " in savings account #" + getAccountNumber()
                    + " and your new balance is " + balance);
        }
    }

    @Override
    public void Withdraw(double amount) {
        if (amount > 0 && (balance - amount) <= balance) {
            balance -= amount;
            System.out.println("Withdrawing " + amount + " in savings account #" + getAccountNumber() +
                    " and your new balance is " + balance);
        } else {
            System.out.println("Amount to withdraw is over the $300 limit per transaction. " +
                    "Please enter an amount that does not exceed $300.");
        }
    }
}
