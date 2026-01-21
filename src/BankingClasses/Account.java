package BankingClasses;

public abstract class Account {
    protected double balance;
    private int accountNumber;

    public Account() {
    }

    public Account( double balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient Funds");
        }
        balance -= amount;
    }

    public void deposit(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount is less than 0");
        }
        balance += amount;
    }

    public abstract String getAccountType();

    public int getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return null;
    }

}