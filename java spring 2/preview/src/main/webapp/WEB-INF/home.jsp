<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
	<body>
		<div class="container">
			<h2>Welcome, ${ user.firstname }</h2>
			<hr />
			<div class="new-event float float-right">
				<p>Plan an Event:</p>
				<form:form action="/home" method="post" modelAttribute="eventForm">
					<form:hidden value="${ user.id }" path="planner"/>
					<div class="form-group">
						<form:label path="name">Name</form:label>
						<form:errors path="name"></form:errors>
						<form:input class="form-control" path="name"></form:input>
					</div>
					<div class="form-group">
						<form:label path="date">Date</form:label>
						<form:errors path="date"></form:errors>
						<form:input class="form-control" type="date" value="${ now }" path="date"></form:input>
					</div>
					 <div class="form-group">
				        <form:label path="location">City</form:label>
				        <form:errors path="location"/>
				        <form:input class="form-control" path="location" />
				    </div>
				    <div class="form-group">
				        <form:label path="stat">State</form:label>
				        <form:errors path="stat"/>
						<form:select class="form-control" path="stat">
						<c:forEach items="${ states }" var="state">
							<option value="${ state }">${ state }</option>
						</c:forEach>
						</form:select>
				    </div>
				    <button>Create Event</button>
			</form:form>
			</div>
			<div class="float float-left">
				<h3>Here are some events in your state:</h3>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>City</th>
							<th>Host</th>
							<th>Action/Status</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ usersStates }" var="event">
						<tr>
							<td><a href="/events/${ event.id }">${ event.name }</a></td>
							<td>${ event.eventDate }</td>
							<td>${ event.city }</td>
							<td>${ event.planner.firstName }</td>
							<td>
							<c:choose>
								<c:when test="${ event.planner.id == user.id }">
									<a href="/events/${ event.id }/edit">Edit</a> |
									<form class="delete-form" action="/events/${ event.id }" method="post">
										<input type="hidden" name="_method" value="delete" />
										<button>Delete</button>
									</form>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ event.attendees.contains(user) }">
											<span>Joining <a href="/events/${ event.id }/a/cancel">Cancel</a></span>
										</c:when>
										<c:otherwise>
											<a href="/events/${ event.id }/a/join">Join</a>								
										</c:otherwise>
									
									</c:choose>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<h3>Here are some events in other states:</h3>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>City</th>
							<th>State</th>
							<th>Host</th>
							<th>Action/Status</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ otherStates }" var="event">
						<tr>
							<td><a href="/events/${ event.id }">${ event.name }</a></td>
							<td>${ event.eventDate }</td>
							<td>${ event.city }</td>
							<td>${ event.state }</td>
							<td>${ event.planner.firstName }</td>
							<td>
							<c:choose>
								<c:when test="${ event.planner.id == user.id }">
									<a href="/events/${ event.id }/edit">Edit</a> |
									<form class="delete-form" action="/events/${ event.id }" method="post">
										<input type="hidden" name="_method" value="delete" />
										<button>Delete</button>
									</form>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ event.attendees.contains(user) }">
											<span>Joining <a href="/events/${ event.id }/a/cancel">Cancel</a></span>
										</c:when>
										<c:otherwise>
											<a href="/events/${ event.id }/a/join">Join</a>								
										</c:otherwise>
									
									</c:choose>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>


</body>
</html>