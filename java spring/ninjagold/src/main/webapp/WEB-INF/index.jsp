<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Your gold</h2>
<label><c:out value="${gold}"></c:out></label></center>
<div style="display:flex;width=1300px;">
<div style="right;width:300px;">
<form action="/earning" method = POST>
<h2>Farm</h2>
<input type="hidden" name="earn" value="farm" />
<p>(earn 10-20 Gold)</p>
<button>find gold!</button>
</form>
</div>
<div style="width:300px;'">
<form action="/earning" method = POST>
<h2>cave</h2>
<input type="hidden" name="earn" value="cave" />
<p>(earn 5-10 Gold)</p>
<button>find gold!</button>
</form>
</div>
<div style="width:300px;"><form action="/earning" method = POST>
<h2>house</h2>
<input type="hidden" name="earn" value="house" />
<p>(earn 2-5 Gold)</p>
<button>find gold!</button>
</form>
</div>

<div style="width:300px;"><form action="/earning" method = POST>
<h2>casino</h2>
<input type="hidden" name="earn" value="casino" />
<p>(earn/take 0-50 Gold)</p>
<button>find gold!</button>
</form>
</div></div>
<center>
        <div>
            <h5><u>Activities</u>:</h5>
            <div>
                <c:forEach var="act" items="${activities}">
                    <li><c:out value="${act}" /></li>
                </c:forEach>
            </div>
</center>
</body>
</html>