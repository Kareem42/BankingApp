package BankingClasses;// Child class - inheritance

public class SavingAccount extends Account {
    public SavingAccount(String ownerName, int accountNumber, double balance) {
        super(ownerName, accountNumber, balance);
    }

    @Override
    public String getAccountType() {
        return "savings account";
    }

//    @Override
//    public void Deposit(double amount) {
//        if (amount > 0) {
//            balance += amount;
//            System.out.println("Deposited $" + amount + " in savings account #" + getAccountNumber()
//                    + " and your new balance is $" + balance);
//        } else {
//            System.out.println("Please enter an amount that is greater than 0.");
//        }
//    }

    @Override
    public void Withdraw(double amount) {
        if (amount <= 0 || amount > 300) {
            System.out.println("Amount to withdraw is over the $300 limit per transaction. " +
                    "Please enter an amount that does not exceed $300.");
        } else if (amount > balance) {
            System.out.println("Amount requested exceeds the available balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawing $" + amount + " in savings account #" + getAccountNumber() +
                    " and your new balance is $" + balance);
        }
    }
}