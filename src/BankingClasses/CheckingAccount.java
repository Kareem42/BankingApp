package BankingClasses;
// Child class - Inheritance

public class CheckingAccount extends Account {
    public CheckingAccount(String ownerName, double balance, int accountNumber, int pin) {
        super(ownerName, balance, accountNumber, pin);
    }

    @Override
    public String getAccountType() {
        return "checking account #";
    }

}
