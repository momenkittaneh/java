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
<a href="/dashboard">dashboard</a>
<p>Title <c:out value="${song.title}"></c:out> </p>
<p>artist <c:out value="${song.artist}"></c:out> </p>
<p>Rating(0-10) <c:out value="${song.rating}"></c:out> </p>
<form action="delete/<c:out value="${song.id}"/>" method="post" value="Delete">
<input type="submit" value="delete">
</form >
</body>
</html>