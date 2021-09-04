<%--
  Created by IntelliJ IDEA.
  User: Vlad Lailo
  Date: 04.09.2021
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>


<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="../styles/for-all.css">
    <link rel="stylesheet" href="../styles/users.css">
</head>
<body>
<main>
    <div class="users-container">
        <h1 class="form-title">
            Users
        </h1>
        <table>
            <thead>
            <tr>
                <td class="tb-title">First name</td>
                <td class="tb-title">Last name</td>
                <td class="tb-title">Age</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.users}" var="user">
                <c:choose>
                    <c:when test="${user != sessionScope.user}">
                        <tr>
                            <td class="tb-cell">${user.firstName}</td>
                            <td class="tb-cell">${user.lastName}</td>
                            <td class="tb-cell">${user.age}</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td style="background-color: #FFFF99" class="tb-cell">${user.firstName}</td>
                            <td style="background-color: #FFFF99" class="tb-cell">${user.lastName}</td>
                            <td style="background-color: #FFFF99" class="tb-cell">${user.age}</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>
        <div class="form-buttons">
            <button class="button"><a href="/welcome-page">Go back</a></button>
        </div>
    </div>
</main>
</body>
</html>
