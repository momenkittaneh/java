<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
<table class="table" style="width: 900px;margin-top: 20px;margin-left: 300px">
  <thead class="thead-dark">
    <tr>
      <th scope="col">language</th>
      <th scope="col">creator</th>
      <th scope="col">version</th>
      <th scope="col">action</th>
    </tr>
  </thead>
		<tbody>
			<c:forEach items="${lang}" var="lan">
					<tr>
				<td><c:out value="${lan.name}"></c:out></td>
				<td><c:out value="${lan.creator}"></c:out></td>
				<td><c:out value="${lan.version}"></c:out></td>
				<td>
				<a href="/languages/<c:out value="${lan.id}"></c:out>">details</a>
				<a href="/languages/<c:out value="${lan.id}/edit"></c:out>">edit</a>
				</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<table  style="width: 900px;margin-top: 60px;margin-left: 500px">
	<form:form action="/languages" method="post" modelAttribute="makenewone">
		<tr>
      	<td><form:label path="name">name:</form:label>
        <td><form:input path="name"/></td>
        <td><form:errors path="name"/></td>
        </tr>
        <tr>
        <td><form:label path="creator">creator:</form:label></td>
        <td><form:input path="creator"/></td>
         <td><form:errors path="creator"/></td>
        </tr>
        <tr>
        <td><form:label path="version">version:</form:label></td>
        <td><form:input path="version"/></td>
        <td><form:errors path="version"/></td>
    	</tr>
    <tr><td><input type="submit" value="Submit"/></td></tr>
</form:form>    
	</table>
	
	
</body>
</html>