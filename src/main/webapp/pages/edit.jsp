<%--
  Created by IntelliJ IDEA.
  User: Vlad Lailo
  Date: 30.08.2021
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="by.teachmeskills.model.User" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../styles/edit.css">
    <link rel="stylesheet" href="../styles/for-all.css">
</head>
<body>
<main>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <div class="edit-form-container">
        <form id="edit" action="/edit" method="post">
            <h1 class="form-title">
                Edit
            </h1>
            <div class="form-fields">
                <div class="form-field">
                    <label for="first_name"></label><input type="text" id="first_name" placeholder="First name"
                                                           value="<%=user.getFirstName()%>"
                                                           name="first_name">
                </div>
                <div class="form-field">
                    <label for="last_name"></label><input type="text" id="last_name" placeholder="Last name"
                                                          value="<%=user.getLastName()%>"
                                                          name="last_name">
                </div>
                <div class="form-field">
                    <label for="age"></label><input type="number" id="age" placeholder="Age" value="<%=user.getAge()%>"
                                                    name="age">
                </div>
            </div>
        </form>
        <div class="form-buttons">
            <button form="edit" class="button">Save</button>
        </div>
    </div>
</main>
</body>
</html>
