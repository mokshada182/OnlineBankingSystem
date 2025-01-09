package com.bank.servlet;

import com.bank.dao.AccountDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

class TransferServletTest {

    private TransferServlet transferServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private AccountDAO accountDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transferServlet = new TransferServlet();
    }

    @Test
    void testDoPostSuccess() throws Exception {
        when(request.getParameter("fromAccount")).thenReturn("ACC123456");
        when(request.getParameter("toAccount")).thenReturn("ACC654321");
        when(request.getParameter("amount")).thenReturn("500");
        when(accountDAO.transferFunds("ACC123456", "ACC654321", 500.0)).thenReturn(true);
        when(request.getRequestDispatcher("transactions.jsp")).thenReturn(dispatcher);

        transferServlet.doPost(request, response);

        verify(response, times(1)).sendRedirect("transactions.jsp");
    }

    @Test
    void testDoPostFailure() throws Exception {
        when(request.getParameter("fromAccount")).thenReturn("ACC123456");
        when(request.getParameter("toAccount")).thenReturn("ACC654321");
        when(request.getParameter("amount")).thenReturn("500");
        when(accountDAO.transferFunds("ACC123456", "ACC654321", 500.0)).thenReturn(false);
        when(request.getRequestDispatcher("transfer.jsp")).thenReturn(dispatcher);

        transferServlet.doPost(request, response);

        verify(dispatcher, times(1)).forward(request, response);
    }
}
