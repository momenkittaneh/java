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
	<h1><c:out value="${myprod.name}"></c:out></h1>
		<c:forEach items="${myprod.categories}" var="cata">
	<p> <c:out value="${cata.name }"></c:out> </p>
	</c:forEach>
	
		<form:form action="/products/${myprod.id}" method="POST" modelAttribute="product">
	
		<p>
			<form:label path="product">add products</form:label>
			<form:select path="product">
				<c:forEach items="${cate}" var="cata" >
					<form:option value="${cata}"> ${cata.name} </form:option>
				</c:forEach>
			
			</form:select>
				<input type="submit" value="Submit"/>
		</p></form:form>
</body>
</html>