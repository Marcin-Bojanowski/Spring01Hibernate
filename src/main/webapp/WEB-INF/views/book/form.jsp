<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="book" >
    <form:errors path="*"/><br>
    Tytuł: <form:input path="title"/><br>
<%--    <form:errors path="title" cssClass="error"/><br>--%>
    Rating:<br>
    <c:forEach begin="1" end="10" var="index">
        <form:radiobutton path="rating" label="${index}" value="${index}"/>
    </c:forEach><br>
<%--    <form:errors path="rating" cssClass="error"/><br>--%>
    Opis: <form:textarea path="description" rows="5" cols="20"/><br>
    Wydawca: <form:select path="publisher">
    <form:option value="0" label="Wybierz wydawcę"/>
    <form:options items="${publishers}" itemValue="id" itemLabel="name"/>
</form:select><br>
<%--    <form:errors path="publisher" cssClass="error"/>--%>

    Author: <form:select path="authors" items="${authors}" itemValue="id" itemLabel="fullName" multiple="true"/><br>

<%--<form:errors path="authors" cssClass="error"/><br>--%>
    Liczba stron: <form:input path="pages"/><br>
    Kategoria: <form:select path="category.id">
    <form:option value="0" label="Wybierz kategorię"/>
    <form:options items="${categories}" itemValue="id" itemLabel="name"/>
</form:select>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
