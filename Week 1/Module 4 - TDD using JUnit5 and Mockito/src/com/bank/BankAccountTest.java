package com.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(500.0);
    }

    @AfterEach
    public void tearDown() {
        account = null;
    }

    @Test
    public void testJUnitSetupAndInitialization() {
        assertNotNull(account);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    public void testDepositIncreasesBalance() {
        double depositAmount = 150.0;
        account.deposit(depositAmount);
        assertEquals(650.0, account.getBalance());
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        double withdrawalAmount = 200.0;
        account.withdraw(withdrawalAmount);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    public void testInvalidDepositThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
    }

    @Test
    public void testOverdraftThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600.0);
        });
    }
}