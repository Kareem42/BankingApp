// Child

public class CheckingAccount extends Account {
    private double balance;
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
    public void getDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " in checking account #" + getAccountNumber()
            + " with balance: " + balance);
        } else  {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void getWithdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 0) {
            balance -= amount;
            System.out.println("Withdrawing " + amount + " in checking account #" + getAccountNumber() +
                    " with balance: " + balance);
        } else   {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void depositToString() {

    }

    @Override
    public void withdrawToString() {

    }
}
