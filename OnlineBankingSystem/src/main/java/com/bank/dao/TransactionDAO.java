package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Transaction;

public class TransactionDAO {
    public List<Transaction> getTransactions(String accountNumber) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM transactions WHERE account_number = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, accountNumber);
        ResultSet rs = stmt.executeQuery();

        List<Transaction> transactions = new ArrayList<>();
        while (rs.next()) {
            Transaction transaction = new Transaction();
            transaction.setDate(rs.getDate("date"));
            transaction.setDescription(rs.getString("description"));
            transaction.setAmount(rs.getDouble("amount"));
            transactions.add(transaction);
        }
        return transactions;
    }
}
