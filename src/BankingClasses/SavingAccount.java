package BankingClasses;
// Child class - inheritance

public class SavingAccount extends Account {
    public SavingAccount(String ownerName, double balance, int accountNumber, int pin) {
        super(ownerName, balance, accountNumber, pin);
    }

    @Override
    public String getAccountType() {
        return "savings account #";
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > 300) {
            throw new Exception("Savings account can't withdraw more than $300");
        }
        super.withdraw(amount); // Used to explicitly call the overridden version of the method from the superclass.
    }
}