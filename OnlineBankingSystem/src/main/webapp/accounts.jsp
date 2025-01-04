<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.html");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounts</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Account Details</h1>
    <table>
        <tr>
            <th>Account Number</th>
            <th>Account Type</th>
            <th>Balance</th>
        </tr>
        <%-- Dynamically load account details from backend --%>
    </table>
</body>
</html>
