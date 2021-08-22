<%--
  Created by IntelliJ IDEA.
  User: Vlad Lailo
  Date: 21.08.2021
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h2>Registration</h2>
    <form action="/registration" method="post">
        <label for="first_name">First name:</label>
        <input type="text" id="first_name" name="first_name">
        <br>
        <label for="last_name">Last name:</label>
        <input type="text" id="last_name" name="last_name">
        <br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age">
        <br>
        <label for="login">Login:</label>
        <input type="text" id="login" name="login">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br>
        <label for="conf_password">Confirm password:</label>
        <input type="password" id="conf_password" name="conf_password">
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
