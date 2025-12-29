package BankingClasses;


import java.util.Scanner;

public abstract class Account {
    Scanner input = new Scanner(System.in);
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

    public int getGeneratedAccountNumber() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public void setGeneratedAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPin() {
        return 1234;
    }

    public void setPin(int pin) {
        System.out.print("Enter your custom pin number: ");
        this.pin = input.nextInt();
    }

    public void getGreeting() {
        System.out.println("Welcome back, " + ownerName + "!. You are currently viewing your "
                + getAccountType() + getAccountNumber() + ". How can we help you today? ");
    }
}