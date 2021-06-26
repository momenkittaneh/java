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
<form:form action="/ninjas/new" method="post" modelAttribute="makenewone">
    <p>
			<form:label path="Dojo">Person</form:label>
			<form:select path="Dojo">
				<c:forEach items="${dejo}" var="person" >
					<form:option value="${person}"> ${person.name} </form:option>
				</c:forEach>
				</form:select>
    <p>
    
        <form:label path="firstName">First name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last name</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>
    <p>
        <form:label path="age">age</form:label>
        <form:errors path="age"/>     
        <form:input type="number" path="age"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    

</body>
</html>