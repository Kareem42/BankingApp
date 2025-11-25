// Parent class
// Using Abstraction

public abstract class Account {
    private String ownerName;
    private int accountNumber;
    protected double balance;

    public Account(String ownerName, int accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() { return balance; }

    public abstract void Withdraw(double amount);

    public abstract void Deposit(double amount);

}
