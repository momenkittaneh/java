<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Total Cities</h1>
<table>
    <thead>
        <tr>
            <th>Country</th>
            <th>Total Cities</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${y}" var="city">
        <tr>
            <td><c:out value="${city[0]}"/></td>
            <td><c:out value="${city[1]}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>