<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-28
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add author</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="author">

    Imię: <form:input path="firstName"/><br>title
    <form:errors path="firstName" cssClass="error"/>
    Nazwisko: <form:input path="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/>
    Pesel: <form:input path="pesel"/><br>
    <form:errors path="pesel" cssClass="error"/>
    Email: <form:input path="email"/><br>
    <form:errors path="email" cssClass="error"/>
    Rok urodzenia: <form:input path="yearOfBirth"/><br>
    <form:errors path="yearOfBirth" cssClass="error"/>

    <input type="submit" value="Send">

</form:form>
</body>
</html>
