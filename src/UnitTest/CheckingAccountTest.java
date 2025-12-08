//package UnitTest;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import BankingClasses.CheckingAccount;
//
//class CheckingAccountTest {
//    CheckingAccount accountType = new CheckingAccount("John Doe", 2456, 300.00);
//
//    @Test
//    @DisplayName("Account Type")
//    void testGetAccountType() {
//        assertEquals("checking account", accountType.getAccountType());
//    }
//    @Test
//    @DisplayName("Checking Account Number")
//    void testAccountNumber() {
//        assertEquals(2456, accountType.getAccountNumber());
//    }
//    @Test
//    @DisplayName("Checking Account Balance")
//    void testAccountBalance() {
//        assertEquals(300,  accountType.getBalance());
//    }
//
//    @Test
//    @DisplayName("Owner")
//    void testGetOwnerName() {
//        assertEquals("John Doe", accountType.getOwnerName());
//    }
//
//    @Test
//    @DisplayName("Withdrawal")
//    void testWithdraw() {
//        CheckingAccount withdrawTest = new CheckingAccount("John Doe", 2456, 300.00);
//        withdrawTest.Withdraw(25.00);
//        assertEquals(300.00, accountType.getBalance());
//    }
//
//    @Test
//    @DisplayName("Deposit")
//    void testDeposit() {
//        CheckingAccount withdrawTest = new CheckingAccount("John Doe", 2456, 300.00);
//        withdrawTest.Deposit(0);
//        assertEquals(300.00, accountType.getBalance());
//    }
//
