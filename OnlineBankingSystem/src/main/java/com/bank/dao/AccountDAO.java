package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {

    public boolean transferFunds(String fromAccount, String toAccount, double amount) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        connection.setAutoCommit(false);

        try {
            // Deduct from source account
            String deductQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            PreparedStatement deductStmt = connection.prepareStatement(deductQuery);
            deductStmt.setDouble(1, amount);
            deductStmt.setString(2, fromAccount);
            int rows1 = deductStmt.executeUpdate();

            // Add to destination account
            String addQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement addStmt = connection.prepareStatement(addQuery);
            addStmt.setDouble(1, amount);
            addStmt.setString(2, toAccount);
            int rows2 = addStmt.executeUpdate();

            if (rows1 > 0 && rows2 > 0) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
