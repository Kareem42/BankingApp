package BankingClasses;
// Child class - Inheritance

public class CheckingAccount extends Account {
    public CheckingAccount(String userId, double balance, int accountNumber, int pin) {
        super(userId, balance, accountNumber, pin);
    }

    @Override
    public String getAccountType() {
        return "checking account #";
    }
}
