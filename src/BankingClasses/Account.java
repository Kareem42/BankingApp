package BankingClasses;

public abstract class Account {
    protected double balance;

    public Account() {
    }

    public Account(String ownerName, double balance, int accountNumber, int pin) {
    }

    public double getBalance() {
        return 5.00;
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

}