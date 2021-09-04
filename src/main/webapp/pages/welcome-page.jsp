<%--
  Created by IntelliJ IDEA.
  User: Vlad Lailo
  Date: 21.08.2021
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<%@ page import="by.teachmeskills.model.User" %>


<html>
<head>
    <title>Welcome-page</title>
    <link rel="stylesheet" href="../styles/welcome-page.css">
    <link rel="stylesheet" href="../styles/for-all.css">
</head>
<body>
<main>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <div class="welcome-form-container">
        <h1 class="form-title">
            Welcome <%=user.getLogin()%>
        </h1>
        <div class="info-fields">
            <h3 class="info-title">
                User info
            </h3>
            <c:if test="<%=user.getAge()>=18%>">
                <div class="info-field">
                    Login: <%=user.getLogin()%> (Adult)
                </div>
            </c:if>
            <c:if test="<%=user.getAge()<18%>">
                <div class="info-field">
                    Login: <%=user.getLogin()%> (Minor)
                </div>
            </c:if>
            <div class="info-field">
                First name: <%=user.getFirstName()%>
            </div>
            <div class="info-field">
                Last name: <%=user.getLastName()%>
            </div>
            <div class="info-field">
                Age: <%=user.getAge()%>
            </div>
        </div>
        <div class="button-fields">
            <button class="button"><a href="/edit">Edit</a></button>
            <button class="button"><a href="/delete">Delete</a></button>
            <button class="button"><a href="/users">All users</a></button>
            <button class="button"><a href="/logout">Logout</a></button>
        </div>
    </div>
</main>
</body>
</html>
