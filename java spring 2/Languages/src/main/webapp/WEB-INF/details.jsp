<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				<a href="/">Dashboard</a><br>
				<c:out value="${language.name}"></c:out><br>
				
				<c:out value="${language.creator}"></c:out><br>
				
				
				<c:out value="${language.version}"></c:out><br>
								<a href="/languages/${language.id}/edit">edit</a><br>
	<form action="delete/<c:out value="${id}"/>" method="post" value="Delete"><br>
	<input type="submit" value="delete">
	
</body>
</html>