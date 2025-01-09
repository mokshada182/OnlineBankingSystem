package com.bank.dao;

import com.bank.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

class TransactionDAOTest {

    private TransactionDAO transactionDAO;

    @BeforeEach
    void setUp() {
        transactionDAO = mock(TransactionDAO.class);
    }

    @Test
    void testGetTransactions() throws Exception {
        List<Transaction> mockTransactions = Collections.singletonList(new Transaction(1, 100.0, "DEPOSIT"));
        when(transactionDAO.getTransactions("ACC123456")).thenReturn(mockTransactions);

        List<Transaction> transactions = transactionDAO.getTransactions("ACC123456");
        assertNotNull(transactions, "Transactions list should not be null");
        assertEquals(1, transactions.size(), "Transactions size should match");
    }
}
