package BankingClasses;

public abstract class Account {
    private final String ownerName;
    protected double balance;

    public Account(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountNumber() {
        return getGeneratedAccountNumber();
    }

    public double getBalance() {
        return balance;
    }

    public void Withdraw(double amount) throws Exception {
        if  (amount > balance){
            throw new Exception("Insufficient Funds");
        }
            balance -= amount;
    }
//    public abstract void Deposit(double amount);

    public void Deposit(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount is less than 0");
        }
        balance += amount;
    }

    public abstract String getAccountType();

    public int getGeneratedAccountNumber() {
        return (int)(Math.random() * 9000) + 1000;
    }
}