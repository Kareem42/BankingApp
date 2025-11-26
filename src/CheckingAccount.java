// Child class - Inheritance

public class CheckingAccount extends Account {
    public CheckingAccount(String ownerName, int accountNumber, double balance) {
        super(ownerName, accountNumber, balance);
    }

    @Override
    public String getAccountType() {
        return "checking account";
    }

    @Override
    public void Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " in checking account #" + getAccountNumber()
            + " and your new balance is $" + balance);
        } else {
            System.out.println("Please enter an amount that is greater than 0.");
        }
    }

    @Override
    public void Withdraw(double amount) {
        if (amount > 0 && (balance - amount) <= balance) {
            balance -= amount;
            System.out.println("Withdrawing $" + amount + " in checking account #" + getAccountNumber() +
                    " and your new balance is $" + balance);
        } else {
            System.out.println("Amount to withdraw is over the $300 limit per transaction. " +
                    "Please enter an amount that does not exceed $300.");
        }
    }
}
