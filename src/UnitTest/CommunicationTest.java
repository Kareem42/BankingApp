package UnitTest;

import BankingClasses.Communication;
import org.junit.jupiter.api.BeforeEach;
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
    public void testAccountOptionsWithLoginAndExit() {
        // Simulate user input: existing user login (choice 2), name "Dennis", pin 1234, then exit
        String simulatedInput = "2\nDennis\n1234\nY\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> communication.accountOptions());
    }

    @Test
    public void testAccountOptionsWithNewUserCreation() {
        // Simulate: new user (choice 1), checking account, name "John", then exit
        String simulatedInput = "1\n1\nJustin\n1\nY";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> communication.accountOptions());
    }

    @Test
    public void testAccountOptionsWithAccountAction() {
        // Simulate: login as existing user, check balance (option 1), logout, then exit
        String simulatedInput = "2\nDennis\n1234\n1\n4\nY\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> communication.accountOptions());
    }
}