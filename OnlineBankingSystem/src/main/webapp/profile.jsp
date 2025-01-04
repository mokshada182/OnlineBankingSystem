<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Your Profile</h1>
    <form action="profile" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required><br>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${user.phone}" required><br>

        <button type="submit">Update</button>
    </form>
    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
