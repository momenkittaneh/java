<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>all dojos</h1>
<c:forEach items="${dejo }" var="dango">
	<c:out value="${dango.name }"></c:out><br>
</c:forEach>
<h1>all ninjas</h1>
<c:forEach items="${nija }" var="naji">
	<c:out value="${ naji.firstName}"></c:out>
	<c:out value="${naji.lastName }"></c:out>
	<c:out value="${naji.age }"></c:out>
		<br>
</c:forEach>
</body>
</html>