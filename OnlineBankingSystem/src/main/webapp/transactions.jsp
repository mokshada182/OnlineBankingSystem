<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Transaction History</h1>
    <table border="1">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="transaction" items="${transactions}">
            <tr>
                <td>${transaction.date}</td>
                <td>${transaction.description}</td>
                <td>${transaction.amount}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
