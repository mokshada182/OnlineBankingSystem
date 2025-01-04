<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Welcome, ${username}</h1>
    <ul>
        <li><a href="profile.jsp">View Profile</a></li>
        <li><a href="transactions.jsp?accountNumber=${accountNumber}">View Transactions</a></li>
        <li><a href="transfer.jsp">Transfer Funds</a></li>
    </ul>
    <a href="logout">Logout</a>
</body>
</html>
