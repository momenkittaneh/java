<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Login Register</title>
</head>
<body>
		<div class="container">
			<form:form class="user-form" action="/register" method="post" modelAttribute="registration">
				<h2>Register</h2>
			 	<div class="form-group">
			        <form:label path="firstname">First Name</form:label>
			        <form:errors path="firstname"/>
			        <form:input class="form-control" path="firstname" />
			    </div>
			    <div class="form-group">
			        <form:label path="lastname">Last Name</form:label>
			        <form:errors path="lastname"/>
			        <form:input class="form-control" path="lastname" />
			    </div>
			    <div class="form-group">
			        <form:label path="email">Email</form:label>
			        <form:errors path="email"/>
			        <form:input type="email" class="form-control" path="email" />
			    </div>
			    <div class="form-group">
			        <form:label path="location">City</form:label>
			        <form:errors path="location"/>
			        <form:input class="form-control" path="location" />
			    </div>
			    <div class="form-group">
			        <form:label path="stat">State</form:label>
			        <form:errors path="stat"/>
					<form:select path="stat">
					<c:forEach items="${ states }" var="stat">
						<option value="${ stat }">${ stat }</option>
					</c:forEach>
					</form:select>
			    </div>
			     <div class="form-group">
			        <form:label path="password">Password</form:label>
			        <form:errors path="password"/>
			        <form:password class="form-control" path="password" />
			    </div>
			    <div class="form-group">
			        <form:label path="passwordConfirmation">Confirm Password</form:label>
			        <form:errors path="passwordConfirmation"/>
			        <form:password class="form-control" path="passwordConfirmation" />
			    </div>
			    <button>Register</button>
			</form:form>
			<form action="/login" class="user-form" method="post">
				<h2>Login</h2>
				<span>${ error }</span>
				<div class="form-group">
					<label for="email">Email</label>
					<input type="email" name="email" id="email" class="form-control" />
				</div>
				<div class="form-group">
			        <label for="password">Password</label>
			        <input type="password" name="password" id="password" class="form-control" />		        
			    </div>
			    <button>Login</button>
			</form>
		</div>
	</body>
</body>
</html>