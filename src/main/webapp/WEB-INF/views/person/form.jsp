<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-22
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    Login:<form:input path="login"/><br>
    Password:<form:password path="password"/><br>
    Email:<form:input path="email"/><br>
    <input type="submit" value="Send">
</form:form>

<%--<form method="post">--%>
<%--    login: <input type="text" name="login"><br>--%>
<%--    password: <input type="password" name="password"><br>--%>
<%--    email: <input type="text" name="email"><br>--%>
<%--    <input type="submit" value="Save">--%>
<%--</form>--%>
</body>
</html>
