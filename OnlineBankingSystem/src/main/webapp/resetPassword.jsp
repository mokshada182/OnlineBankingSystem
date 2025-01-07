<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Password</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Reset Password</h2>
    <form action="resetPassword" method="post">
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>New Password:</label>
        <input type="password" name="newPassword" required><br>
        <button type="submit">Reset Password</button>
    </form>
    <p><a href="login.jsp">Back to Login</a></p>
</body>
</html>
