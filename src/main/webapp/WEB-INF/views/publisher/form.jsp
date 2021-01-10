<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-28
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Publisher</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    Nazwa: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/>
    NIP: <form:input path="nip"/><br>
    <form:errors path="nip" cssClass="error"/>
    REGON: <form:input path="regon"/><br>
    <form:errors path="regon" cssClass="error"/>
    <input type="submit" value="Send">

</form:form>
</body>
</html>
