package BankingClasses;// Parent class
// Using Abstraction
// final is used for the Owner Name and account number in order for those variables not to change

public abstract class Account {
    private final String ownerName;
    private final int accountNumber;
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

    public double getBalance() {
        return balance;
    }

    public abstract void Withdraw(double amount);

    public abstract void Deposit(double amount);

    public abstract String getAccountType();
}
