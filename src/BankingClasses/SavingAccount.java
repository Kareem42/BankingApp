package BankingClasses;
// Child class - inheritance

public class SavingAccount extends Account {
    public SavingAccount(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public String getAccountType() {
        return "savings account #";
    }


    @Override
    public void Withdraw(double amount) throws Exception {
        if (amount > 300 )
        {
            throw new Exception("Savings account can't withdraw more than $300");
        }
        super.Withdraw(amount); // Used to explicitly call the overridden version of the method from the superclass.
    }
}