package com.bank.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        TransactionDAO transactionDAO = new TransactionDAO();

        try {
            List<Transaction> transactions = transactionDAO.getTransactions(accountNumber);
            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("transactions.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
