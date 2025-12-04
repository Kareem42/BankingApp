package BankingClasses;// Child class - Inheritance

public class CheckingAccount extends Account {
    public CheckingAccount(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public String getAccountType() {
        return "checking account #";
    }

}
