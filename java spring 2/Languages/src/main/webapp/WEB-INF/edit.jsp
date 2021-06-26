<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    <%@ page isErrorPage="true" %>    
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<%@ page isErrorPage="true" %>    
	<title>Edit</title>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div  style="width: 900px;margin-top: 60px;margin-left: 500px">
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<p><form:errors path="name" class="alert alert-danger"/></p>
			
		    <p>
		        <form:label cssClass="h4" path="name">Name: </form:label>
		        <form:input   path="name"/>
		    </p>
		    
		    <p><form:errors path="creator" class="alert alert-danger"/></p>
		    <p>
		        <form:label cssClass="h4" path="creator">Creator: </form:label>
		       
		        <form:input path="creator"/>
		    </p>
		    
		    <p><form:errors path="version" class="alert alert-danger"/></p>
		    <p>
		        <form:label cssClass="h4" path="version">Version: </form:label>
		        
		        <form:input path="version"/>
		    </p>
		      
		    <input class="btn btn-outline-dark " type="submit" value="Submit"/>
	</form:form>
  
	</div>
</body>
</html>