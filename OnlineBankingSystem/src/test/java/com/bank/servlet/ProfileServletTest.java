package com.bank.servlet;

import com.bank.dao.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

class ProfileServletTest {

    private ProfileServlet profileServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private UserDAO userDAO;

    @Mock
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        profileServlet = new ProfileServlet();
    }

    @Test
    void testDoGetValidSession() throws Exception {
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userId")).thenReturn(1);
        when(userDAO.getUserById(1)).thenReturn(null);
        when(request.getRequestDispatcher("profile.jsp")).thenReturn(dispatcher);

        profileServlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher("profile.jsp");
    }

    @Test
    void testDoGetInvalidSession() throws Exception {
        when(request.getSession(false)).thenReturn(null);

        profileServlet.doGet(request, response);

        verify(response, times(1)).sendRedirect("login.jsp");
    }
}
