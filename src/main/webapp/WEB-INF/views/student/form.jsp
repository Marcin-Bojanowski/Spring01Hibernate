<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-22
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    First name:<form:input path="firstName"/><br>
    Last name:<form:input path="lastName"/><br>
    Gender:<form:radiobutton path="gender" label="M" value="M"/>
            <form:radiobutton path="gender" label="F" value="F"/><br>
    Country:<form:select path="country">
             <form:option value="-" label="--Please select--"/>
            <form:options items="${countries}"/>
            </form:select><br>
    Notes:<form:textarea path="notes"/><br>
    Mailing list:<form:checkbox path="mailingList" value="true" label="true"/>
    <form:checkbox path="mailingList" value="false" label="false"/><br>
    Programming skills:<form:select path="programmingSkills" multiple="true" items="${skills}"/>
    <br>
    Hobbies:<form:checkboxes path="hobbies" items="${hobbies}"/><br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
