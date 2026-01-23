package BankingClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserOperations {
    private int pin;
    private final User user;
    private final List<Account> userAccountList;
    private final List<CheckingAccount> userChecking = new ArrayList<>();
    private final List<SavingAccount> userSavings = new ArrayList<>();
    private final Set<Integer> existingAccountNumbers = new HashSet<>();

    public UserOperations(User user, int pinNumber, List<Account> userAccountList) {
        this.user = user;
        this.pin = pinNumber;
        this.userAccountList = userAccountList;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Account> getUserAccountList() {
        return userAccountList;
    }

    private int getGeneratedAccountNumber() {
        int accountNumber;
        do {
            accountNumber = (int) (Math.random() * 9000) + 1000;
        } while (existingAccountNumbers.contains(accountNumber));
        existingAccountNumbers.add(accountNumber);
        return accountNumber;
    }

    public void createCheckingAccount(double balance) {
        int generatedAccountNumber = getGeneratedAccountNumber();
        CheckingAccount newCheckingAccount = new CheckingAccount(balance, generatedAccountNumber);
        userChecking.add(newCheckingAccount);
        userAccountList.add(newCheckingAccount);
    }

    public void createSavingAccount(double balance) {
        int generatedAccountNumber = getGeneratedAccountNumber();
        SavingAccount newSavingAccount = new SavingAccount(balance, generatedAccountNumber);
        userSavings.add(newSavingAccount);
        userAccountList.add(newSavingAccount);
    }

    public User getUser() {
        return user;
    }

    public List<CheckingAccount> getCheckingAccountList() {
        return userChecking;
    }

    public List<SavingAccount> getSavingAccountList() {
        return userSavings;
    }

    public CheckingAccount getCheckingAccount(int checkingAccountNumber) {
        for (CheckingAccount checkingAccount : userChecking) {
            if (checkingAccount.getAccountNumber() == checkingAccountNumber) {
                return checkingAccount;
            }
        }
        return null;
    }

    public SavingAccount getSavingAccount(int savingAccountNumber) {
        for (SavingAccount userSaving : userSavings) {
            if (userSaving.getAccountNumber() == savingAccountNumber) {
                return userSaving;
            }
        }
        return null;
    }

    public List<String> getAccountNumberList() {
        List<String> accountNumberList = new ArrayList<>();

        for (CheckingAccount checkingAccount : userChecking) {
            accountNumberList.add("checking " + checkingAccount.getAccountNumber());
        }
        for (SavingAccount userSaving : userSavings) {
            accountNumberList.add("saving " + userSaving.getAccountNumber());
        }
        return accountNumberList;
    }

//    public void getGreeting() {
//        System.out.println("Welcome back, " + userId + "! You are currently viewing your account "
//                + accountNumber + ". How can we help you today?");
//    }
}
