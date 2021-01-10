<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-22
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Tytuł</td>
        <td>Rating</td>
        <td>Opis</td>
        <td>Wydawca</td>
        <td>Autor</td>
        <td>Kategoria</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td>
                <c:forEach items="${book.authors}" var="author">
                    ${author.fullName}<br>
                </c:forEach>
            </td>
            <td>${book.category.name}</td>
            <td><a href="/book/edit?id=${book.id} ">Edytuj</a>
                <a href="/book/confirmDelete?id=${book.id}">Usuń</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
