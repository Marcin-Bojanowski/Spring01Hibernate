<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-28
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All publishers</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Nazwa</td>
        <td>NIP</td>
        <td>REGON</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.name}</td>
            <td>${publisher.nip}</td>
            <td>${publisher.regon}</td>
            <td><a href="/publisher/edit?id=${publisher.id} ">Edytuj</a>
                    <%--                <a href="/book/confirmDelete?id=${book.id}">Usuń</a>--%>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
