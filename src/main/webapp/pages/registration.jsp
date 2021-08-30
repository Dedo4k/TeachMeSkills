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
    <link rel="stylesheet" href="../styles/registration.css">
</head>
<body>
<main>
    <div class="registration-form-container">
        <form id="registration" action="/registration" method="post">
            <h1 class="form-title">
                Registration
            </h1>
            <div class="form-fields">
                <div class="form-field">
                    <label for="first_name"></label><input type="text" id="first_name" placeholder="First name"
                                                           name="first_name">
                </div>
                <div class="form-field">
                    <label for="last_name"></label><input type="text" id="last_name" placeholder="Last name"
                                                          name="last_name">
                </div>
                <div class="form-field">
                    <label for="age"></label><input type="number" id="age" placeholder="Age" name="age">
                </div>
                <div class="form-field">
                    <label for="login"></label><input type="text" id="login" placeholder="Login" name="login">
                </div>
                <div class="form-field">
                    <label for="password"></label><input type="password" id="password" placeholder="Password"
                                                         name="password">
                </div>
                <div class="form-field">
                    <label for="conf_password"></label><input type="password" id="conf_password"
                                                              placeholder="Confirm password" name="conf_password">
                </div>
            </div>
        </form>
        <div class="form-buttons">
            <button form="registration" class="button">Sign up</button>
        </div>
    </div>
</main>
</body>
</html>
