package UnitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import BankingClasses.CheckingAccount;
import java.util.Scanner;

class CheckingAccountTest {
    CheckingAccount accountType = new CheckingAccount("John Doe", 2456, 300.00);

    @Test
    @DisplayName("Account Type")
    void testGetAccountType() {
        assertEquals("checking account", accountType.getAccountType());
    }
    @Test
    @DisplayName("Checking Account Number")
    void testAccountNumber() {
        assertEquals(2456, accountType.getAccountNumber());
    }
    @Test
    @DisplayName("Checking Account Balance")
    void testAccountBalance() {
        assertEquals(300,  accountType.getBalance());
    }

    @Test
    @DisplayName("Owner")
    void testGetOwnerName() {
        assertEquals("John Doe", accountType.getOwnerName());
    }


    // Need to create a test that will read the user input and test the Deposit method
    public double readDeposit() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    @Test
    @DisplayName("Deposit")
    void testDeposit() {
        assertTrue(readDeposit() > 0);
    }

//    @Test
//    @DisplayName("Withdrawal")
//    void testWithdraw() {
//    }
}
