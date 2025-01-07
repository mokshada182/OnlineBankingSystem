<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Your Profile</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Your Profile</h1>
    
    <!-- Display Success or Error Messages -->
    <c:if test="${not empty param.message}">
        <p style="color: green;">${param.message}</p>
    </c:if>
    <c:if test="${not empty param.error}">
        <p style="color: red;">${param.error}</p>
    </c:if>

    <form action="profile" method="post">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" value="${user.username}" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required><br>

        <button type="submit">Update Profile</button>
    </form>

    <br>
    <a href="dashboard.jsp">Back to Dashboard</a>
</body>
</html>
