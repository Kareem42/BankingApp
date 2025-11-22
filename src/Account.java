// Parent class
// Using Abstraction

public abstract class Account {
    private String ownerName;
    private int accountNumber;
    protected double balance;

    public Account() {}

    public Account(String ownerName, int accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getOwnerName() {
        return "John Doe";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() { return balance; }

    public void getWithdraw() {
    }

    public void getDeposit() {}

    public abstract void getWithdraw(double amount);

    public abstract void getDeposit(double amount);

    public abstract void depositToString();

    public abstract void withdrawToString();

}
