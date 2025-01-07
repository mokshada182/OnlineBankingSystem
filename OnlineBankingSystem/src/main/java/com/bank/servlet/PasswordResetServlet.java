package com.bank.servlet;

import com.bank.dao.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resetPassword")
public class PasswordResetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");

        UserDAO userDAO = new UserDAO();
        try {
            boolean success = userDAO.resetPassword(email, newPassword);
            if (success) {
                response.sendRedirect("login.jsp?message=Password reset successfully");
            } else {
                response.sendRedirect("resetPassword.jsp?error=Email not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
