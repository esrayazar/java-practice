<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add an Album</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Create a new Album</h1>
<hr>
<h3>Spring MVC Forms</h3>
<form:form method="POST" action="/new" modelAttribute="album">
<form:label path="albumName">Album Name</form:label>
<form:errors path="albumName"/>
<form:input type="text" path="albumName"/>
<form:label path="bandName">Band Name</form:label>
<form:errors path="bandName"/>
<form:input type="text" path="bandName"/>
<form:label path="year">Year</form:label>
<form:errors path="year"/>
<form:input type="text" path="year"/>
<form:label path="yearBought">Year Bought</form:label>
<form:errors path="yearBought"/>
<form:input type="date" path="yearBought"/>
<p><button>Create Album</button>
</form:form>
<h3>HTML Forms Way</h3>
<form action="/new" METHOD ="Post">
<p>Album Name: </p>
<input name="albumName" type ="text">
<p>Band Name: </p>
<input name="bandName" type ="text">
<p>Release Year: </p>
<input name="year" type ="text">
<button>Add Album</button>
</form>
</div>
</body>
</html>