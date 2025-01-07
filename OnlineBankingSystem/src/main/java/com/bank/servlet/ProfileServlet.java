package com.bank.servlet;

import com.bank.dao.UserDAO;
import com.bank.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        UserDAO userDAO = new UserDAO();
        try {
            User user = userDAO.getUserById(userId);
            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp?error=Invalid session");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");

        if (email == null || fullName == null || email.trim().isEmpty() || fullName.trim().isEmpty()) {
            response.sendRedirect("profile.jsp?error=All fields are required");
            return;
        }

        UserDAO userDAO = new UserDAO();
        try {
            boolean success = userDAO.updateProfile(userId, email, fullName);
            if (success) {
                response.sendRedirect("profile.jsp?message=Profile updated successfully");
            } else {
                response.sendRedirect("profile.jsp?error=Update failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
