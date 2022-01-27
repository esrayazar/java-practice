<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:partial>
<body>
<div class="container">
<h1>Create a New Album</h1>
<p>
	<a href="/albums/dashboard"> Album Dashboard</a>
	<a href="/logout">Logout</a>

<form:form action="/albums/dashboard/create" method="post" modelAttribute="album">
	<div class="form-group">
		<form:label path="albumName">Album Name</form:label>
		<form:errors  class="text-danger" path="albumName"/>
		<form:input class="form-control" path="albumName"/>
	</div>
	<div class="form-group">
		<form:label path="description">Description</form:label>
		<form:errors class="text-danger"  path="description"/>
		<form:input class="form-control" path="description"/>
	</div>
	
	<input type="submit" class="btn btn-primary" value="Submit"/>
</form:form>


</div>
</t:partial>
</body>
