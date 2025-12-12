package BankingClasses;
// Child class - Inheritance

public class CheckingAccount extends Account {
    public CheckingAccount(String ownerName, double balance, int accountNumber) {
        super(ownerName, balance,  accountNumber);
    }

    @Override
    public String getAccountType() {
        return "checking account #";
    }

}
