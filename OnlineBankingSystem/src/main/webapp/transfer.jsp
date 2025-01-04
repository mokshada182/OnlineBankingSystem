<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer Funds</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Transfer Funds</h1>
    <form action="transfer" method="post">
        <label for="fromAccount">From Account:</label>
        <input type="text" id="fromAccount" name="fromAccount" required><br>

        <label for="toAccount">To Account:</label>
        <input type="text" id="toAccount" name="toAccount" required><br>

        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required><br>

        <button type="submit">Transfer</button>
    </form>
    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
