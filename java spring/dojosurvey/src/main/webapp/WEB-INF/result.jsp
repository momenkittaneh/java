<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DojoSurvey</title>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1> Submitted info</h1>
	<label>Name</label>
	<c:out value="${name}"></c:out><br>
		<label>Dojo location</label>
	<c:out value="${city}"></c:out><br>
		<label>Favorite language</label>
	<c:out value="${language}"></c:out><br>
		<label>Comment</label>
	<c:out value="${comment}"></c:out><br>
</body>
</html>
