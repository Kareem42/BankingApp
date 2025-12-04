//package UnitTest;
//
//import BankingClasses.SavingAccount;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class SavingsAccountTest {
//    SavingAccount accountType = new SavingAccount("John Doe", 2456, 300.00);
//
//    @Test
//    @DisplayName("Account Type")
//    void testGetAccountType() {
//        assertEquals("savings account", accountType.getAccountType());
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
////    @Test
////    @DisplayName("Withdrawal")
////    void testWithdraw() {
////        SavingAccount withdrawTest = new SavingAccount("John Doe", 2456, 300.00);
////        withdrawTest.Withdraw(301.00);
////        assertEquals(300.00, accountType.getBalance());
////    }

