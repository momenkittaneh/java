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
<a href="/songs/new">Add new</a>
<a href="/search/top10">Top Songs</a>
			<form action="/search" class="float-right">
				<input type="text" name="artist"/>
				<button class="btn btn-primary">Search Artists</button>
			</form>



<table>
<thead>
<td>Name</td>
<td>rating</td>
<td>actions</td>
</thead>
<tbody>
<c:forEach items="${thesongs}" var="song">
<tr>
<td><c:out value="${song.title}"></c:out></td>
<td><c:out value="${song.rating}"></c:out></td>
<td><form action="songs/delete/<c:out value="${song.id}"/>" method="post" value="Delete">
<input type="submit" value="delete">
</form ></td>

</tr></c:forEach>
</tbody>
</table>
</body>
</html>