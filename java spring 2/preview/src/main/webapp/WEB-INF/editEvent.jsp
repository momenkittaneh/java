<%@ page language="java" contentType="text/html; charset=UTF-8"
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Edit Event</title>
</head>
	<body>
		<div class="container">
			<h2>Edit <strong>${ event.name }</strong></h2>
			<form:form action="/events/${ event.id }" method="post" modelAttribute="event">
				<input type="hidden" name="_method" value="put">
				<form:hidden value="${ userId }" path="planner"/>
				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:errors path="name"></form:errors>
					<form:input class="form-control" path="name"></form:input>
				</div>
				<div class="form-group">
					<form:label path="eventDate">Date</form:label>
					<form:errors path="eventDate"></form:errors>
					<form:input class="form-control" type="date" path="eventDate"></form:input>
				</div>
				 <div class="form-group">
			        <form:label path="location">City</form:label>
			        <form:errors path="location"/>
			        <form:input class="form-control" path="location" />
			    </div>
			    <div class="form-group">
			        <form:label path="state">State</form:label>
			        <form:errors path="state"/>
					<form:select class="form-control" path="state">
					<c:forEach items="${ states }" var="state">
						<c:choose>
							<c:when  test="${ state.equals(event.state) }">
								<option selected value="${ state }">${ state }</option>
							</c:when>
							<c:otherwise>
								<option value="${ state }">${ state }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</form:select>
			    </div>
			    <button>Update Event</button>
			</form:form>
		</div>
	</body>

</html>