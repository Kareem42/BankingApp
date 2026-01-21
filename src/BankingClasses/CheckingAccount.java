package BankingClasses;
// Child class - Inheritance

public class CheckingAccount extends Account {
    public CheckingAccount( double balance, int accountNumber) {
        super(balance, accountNumber);
    }

    @Override
    public String getAccountType() {
        return "checking account #";
    }
}
