<%--
  Created by IntelliJ IDEA.
  User: Vlad Lailo
  Date: 21.08.2021
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../styles/login.css">
    <link rel="stylesheet" href="../styles/for-all.css">
</head>
<body>
<main>
    <div class="login-form-container">
        <form id="login" action="/login" method="post">
            <h1 class="form-title">
                Login
            </h1>
            <div class="form-fields">
                <div class="form-field">
                    <label>
                        <input type="text" placeholder="Login" name="login">
                    </label>
                </div>
                <div class="form-field">
                    <label>
                        <input type="password" placeholder="Password" name="password">
                    </label>
                </div>
            </div>
        </form>
        <div class="form-buttons">
            <button form="login" class="button">Sign in</button>
            <div class="divider">or</div>
            <button class="button"><a href="/registration" class="registration">Sign up</a></button>
        </div>
    </div>
</main>
</body>
</html>
