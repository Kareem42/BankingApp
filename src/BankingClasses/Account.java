package BankingClasses;

public abstract class Account  {
    private String ownerName;
    protected double balance;
    private int accountNumber;

    public Account(String ownerName, double balance,  int accountNumber) {
        this.ownerName = ownerName;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }


    public String getOwnerName() {
        return ownerName; // returning an actual name for testing purposes
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {return balance;}

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