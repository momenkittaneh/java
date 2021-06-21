<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DojoSurvey</title>
</head>
<body>
	<form action="/result" method="post">
	<label>Your Name</label>
	<input type="text" name="name"><br>
	<label>Dojo Location :</label>
    <select id="city" name="city">
    <option value="Sanjose">San Jose</option>
    <option value="ny">NewYork</option>
    <option value="palestine">palestine</option>
    <option value="jordan">jordan</option>
  </select><br>
  	<label>Favorite language  :</label>
  
      <select id="language" name="language">
    <option value="python">Python</option>
    <option value="java">Java</option>
    <option value="c++">C++</option>
  </select><br>
  <label>Comment(Optinal)</label>
  <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
  <button>Button</button>
	</form>
</body>
</html>