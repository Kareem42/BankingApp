package BankingClasses;

// Uses for record class vs java class
/*
- All fields are implicitly final
- No inheritance, which means it can't be extended by another class
- No instance fields
- Can implement interfaces, allowing them to participate in various behaviors and platforms
- Can have methods
 */

public record User(String firstName, String lastName, String userName, int pin) {

    private static UserOperations userOperations;

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
        User.userOperations = userOperations;
    }
}