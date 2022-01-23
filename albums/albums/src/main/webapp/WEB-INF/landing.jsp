<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
    
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
<h1>Welcome to Albums dot com</h1>
<div class="row">
<div class="column">
<h3>Register</h3>
	<form:form action="/registerUser" method="post" modelAttribute="user">
	<div class="form-group">
		<form:label path="firstName">First Name</form:label>
		<form:errors path="firstName"/>
		<form:input class="form-control" path="firstName"/>
	</div>
	<div class="form-group">
		<form:label path="lastName">Last Name</form:label>
		<form:errors path="lastName"/>
		<form:input class="form-control" path="lastName"/>
	</div>
	<div class="form-group">
		<form:label path="email">Email</form:label>
		<form:errors path="email"/>
		<form:input type="email" class="form-control" path="email"/>
	</div>
	<div class="form-group">
		<form:label path="password">Password</form:label>
		<form:errors path="password"/>
		<form:input type="password" class="form-control" path="password"/>
	</div>
	<div class="form-group">
		<form:label path="confirmPassword">Confirm Password</form:label>
		<form:errors path="confirmPassword"/>
		<form:input type="password" class="form-control" path="confirmPassword"/>
	</div>
	<input class="btn btn-primary" type="submit" value="Submit"/>
	</form:form>



</div>
</div>
</div>
</body>
</html>