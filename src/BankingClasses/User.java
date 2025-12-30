package BankingClasses;

import java.util.*;

public class User {
    private String userId;
    private int pinNumber;
    private final int accountNumber;
    private final List<Account> userAccountList = new ArrayList<>();

    public User(String userId, int pinNumber, int pin) {
        this.userId = userId;
        this.pinNumber = pinNumber;
        this.accountNumber = getGeneratedAccountNumber();
        initializeAccounts();
    }

    private void initializeAccounts() {
        userAccountList.add(new CheckingAccount(userId, 0.0, getGeneratedAccountNumber(), pinNumber));
        userAccountList.add(new SavingAccount(userId, 0.0, getGeneratedAccountNumber(), pinNumber));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public List<Account> getUserAccountList() {
        return userAccountList;
    }

    public int getGeneratedAccountNumber() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public void getGreeting() {
        System.out.println("Welcome back, " + userId + "! You are currently viewing your account "
                + accountNumber + ". How can we help you today?");
    }
}


