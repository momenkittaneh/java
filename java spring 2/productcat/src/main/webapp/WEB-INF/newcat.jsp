<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>New Catagory</h1>
		<form:form action="/catagories/new" method="post" modelAttribute="newcat">
			<p>
				<form:label path="name">name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
				<input type="submit" value="Submit"/>
		</form:form>    			
	</center>
</body>
</html>