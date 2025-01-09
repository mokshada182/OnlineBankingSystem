package com.bank.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountDAOTest {

    private AccountDAO accountDAO;

    @BeforeEach
    void setUp() {
        accountDAO = mock(AccountDAO.class);
    }

    @Test
    void testTransferFunds() throws Exception {
        when(accountDAO.transferFunds("ACC123456", "ACC654321", 500.0)).thenReturn(true);

        boolean result = accountDAO.transferFunds("ACC123456", "ACC654321", 500.0);
        assertTrue(result, "Transfer should succeed");
    }

    @Test
    void testTransferFundsFailure() throws Exception {
        when(accountDAO.transferFunds("ACC123456", "ACC654321", 500.0)).thenReturn(false);

        boolean result = accountDAO.transferFunds("ACC123456", "ACC654321", 500.0);
        assertFalse(result, "Transfer should fail");
    }
}
