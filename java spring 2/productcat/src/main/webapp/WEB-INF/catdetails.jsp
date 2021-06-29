<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${mycat.name}"></c:out></h1>
		<c:forEach items="${mycat.products}" var="prod">
	<p> <c:out value="${prod.name }"></c:out> </p>
	</c:forEach>
	
		<form:form action="/catagories/${mycat.id}" method="POST" modelAttribute="product">
	
		<p>
			<form:label path="product">add catagory</form:label>
			<form:select path="product">
				<c:forEach items="${prod}" var="product" >
					<form:option value="${product}"> ${product.name} </form:option>
				</c:forEach>
			
			</form:select>
				<input type="submit" value="Submit"/>
		</p></form:form>
</body>
</html>