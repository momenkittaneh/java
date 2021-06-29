<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Event Info</title>
</head>
	<body>
		<div class="container">
			<h2>${ event.name }</h2>
			<div class="event-details-side">
				<h4><strong>Host:</strong> ${ event.planner.firstname }</h4>
				<h4><strong>Date:</strong> ${ event.date }</h4>
				<h4><strong>Location:</strong> ${ event.location }</h4>
				<h4><strong>People attending:</strong> ${ event.join.size() }</h4>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ event.join }" var="user">
						<tr>
							<td>${ user.firstname } ${ user.lastname }</td>
							<td>${ user.location }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="event-details-side">
				<h3>Message Wall</h3>
				<div class="messages">
				<c:forEach items="${ event.comment }" var="message">
					<p>${ message.mycomm.firstname } says: ${ message.messeage }</p>
				</c:forEach>
				</div>
				<form action="/events/${event.id}" method="post">
					<div class="form-group">
						<label for="comment">Add Comment</label>
						<span>${ error }</span>
						<textarea name="comment" id="comment" class="form-control"></textarea>
						<button>Submit</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</body>
</html>