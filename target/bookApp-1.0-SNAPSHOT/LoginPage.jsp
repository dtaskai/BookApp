<%--
  Created by IntelliJ IDEA.
  User: taska
  Date: 4/23/2021
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="j_security_check">
    <p>
        <span>Username:</span>
        <br/>
        <input type="text" name="j_username">
    </p>
    <p>
        <span>Password:</span>
        <br/>
        <input type="password" name="j_password">
    </p>
    <p>
        <input type="submit" value="Login">
    </p>
</form>
</body>
</html>
