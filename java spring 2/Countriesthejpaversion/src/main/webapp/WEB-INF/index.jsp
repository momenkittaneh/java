<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Queries!</title>
</head>
<body>
<h1>Country Speak Slovene</h1>
<table>
    <thead>
        <tr>
            <th>Country</th>
            <th>Percentage</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${x}" var="country">
        <tr>
            <td><c:out value="${country[2]}"/></td>
            <td><c:out value="${country[1]}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>