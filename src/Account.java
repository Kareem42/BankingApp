// Parent class

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

    public void getWithdraw() {
    }

    public abstract void getWithdraw(double amount);

    public abstract void getDeposit(double amount);

    public abstract void depositToString();

    public abstract void withdrawToString();
}
