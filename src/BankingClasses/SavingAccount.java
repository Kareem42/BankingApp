package BankingClasses;
// Child class - Inheritance

public class SavingAccount extends Account {
    public SavingAccount( double balance, int accountNumber ) {
        super(balance, accountNumber);
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