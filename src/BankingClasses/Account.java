package BankingClasses;

public abstract class Account  {
    private String ownerName;
    protected double balance;
    private int accountNumber;
    private int pin;

    public Account(String ownerName, double balance, int accountNumber, int pin) {
        this.ownerName = ownerName;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }


    public String getOwnerName() {
        return ownerName;
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

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}