<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-28
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All authors</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>Pesel</td>
        <td>Email</td>
        <td>Rok urodzenia</td>
 <td>Akcja</td>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>${author.pesel}</td>
            <td>${author.email}</td>
            <td>${author.yearOfBirth}</td>
            <td><a href="/author/edit?id=${author.id} ">Edytuj</a>
<%--                <a href="/book/confirmDelete?id=${book.id}">Usuń</a>--%>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
