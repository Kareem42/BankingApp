package BankingClasses;

public class User {
    String firstName, lastName, userName;
    int pin;
    private UserOperations userOperations;

    public User(String firstName, String lastName, String userName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.pin = pin;
    }

    public int getAccountNumber() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public int getPin() {
        return pin;
    }

    public UserOperations getUserOperations() {
        return userOperations;
    }

    public void setUserOperations(UserOperations userOperations) {
        this.userOperations = userOperations;
    }
}