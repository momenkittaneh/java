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
<h3>top ten songs:</h3>
<a href="/dashboard">dashboard</a>
<div>
<c:forEach items="${top10}" var="songs">
<c:out value="${songs.rating}"></c:out>-
<a href="/songs/${songs.id}"><c:out value="${songs.title}"></c:out></a>
<c:out value="${songs.artist}"></c:out><br>
</c:forEach>
</div>

</body>
</html>