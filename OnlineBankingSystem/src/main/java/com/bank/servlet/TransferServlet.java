package com.bank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.AccountDAO;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));

        AccountDAO accountDAO = new AccountDAO();
        try {
            boolean success = accountDAO.transferFunds(fromAccount, toAccount, amount);
            if (success) {
                response.sendRedirect("transactions.jsp");
            } else {
                request.setAttribute("error", "Transfer failed. Please try again.");
                request.getRequestDispatcher("transfer.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
