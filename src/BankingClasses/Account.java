package BankingClasses;// Parent class
// Using Abstraction
// final is used for the Owner Name and account number in order for those variables not to change

public abstract class Account {
    private final String ownerName;
    private final int accountNumber;
    protected double balance;

    public Account(String ownerName, int accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void Withdraw(double amount);
//    public abstract void Deposit(double amount);

    public void Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " in checking account #" + getAccountNumber()
                    + " and your new balance is $" + balance);
        } else {
            System.out.println("Please enter an amount that is greater than 0.");
        }
    }

    public abstract String getAccountType();
}