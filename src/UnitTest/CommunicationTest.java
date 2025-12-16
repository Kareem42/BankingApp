package UnitTest;

import BankingClasses.Communication;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationTest {
    private Communication communication;

    @BeforeEach
    public void setUp() {
        communication = new Communication();
    }

    @Test
    @DisplayName("Log in and log out")
    public void testAccountOptionsWithLoginAndExit() {
        // Simulate user input: existing user login (choice 2), name "Dennis", pin 1010, checks balance,
        // log out, then exit.
        String simulatedInput = "2\nDennis\n1010\n1\n4\nY";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> communication.accountOptions());
    }

    @Test
    @DisplayName("New User Creation")
    public void testAccountOptionsWithNewUserCreation() {
        // Simulate: new user (choice 1), checking account, name "John", checks balance, log out, then exit
        String simulatedInput = "1\n1\nJohn\n1\n4\nY";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> communication.accountOptions());
    }

    @Test
    @DisplayName("Deposit Test")
    public void testAccountOptionsWithAccountActionDeposit() {
        // Simulate: login as existing user, check balance (option 2), logout, then exit
        String simulatedInput = "2\nDennis\n1010\n2\n500\n4\nY\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> communication.accountOptions());
    }

    @Test
    @DisplayName("Withdrawal Test")
    public void testAccountOptionsWithAccountActionWithdrawal() {
        // Simulate: login as existing user, check balance (option 2), logout, then exit
        String simulatedInput = "2\nDennis\n1010\n3\n5\n4\nY\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> communication.accountOptions());
    }
}