<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-23
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Violations</title>
</head>
<body>
<c:forEach items="${violations}" var="viol">
    ${viol.propertyPath}
   ${viol.message}<br>
</c:forEach>
</body>
</html>
