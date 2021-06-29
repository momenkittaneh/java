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
<h1>Top Languages</h1>
<table>
    <thead>
        <tr>
            <th>Country</th>
            <th>Languages</th>
            <th>Percentage</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${z}" var="languages">
        <tr>
           <td><c:out value="${languages[0]}"/></td>
            <td><c:out value="${languages[1]}"/></td>
            <td><c:out value="${languages[2]}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>