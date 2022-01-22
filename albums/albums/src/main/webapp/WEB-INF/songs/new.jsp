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
<title>Add New Song</title>
</head>
<body>
<div class="container">
<h2>Add a New Song</h2>
<form:form method="post" action ="/song/newSong" modelAttribute="song">
<div class="form-control">
<form:label path="name"> Song Name:</form:label>
<form:errors path="name"/>
<form:input type="text" path="name"/>
</div>
<div class="form-control">
<form:label path="length"> Song Length:</form:label>
<form:errors path="length"/>
<form:input type="text" path="length"/>
</div>
<form:select path="albumSongIsOn"> 
<c:forEach items="${albums}" var="album">
<option value="${album.id}"> ${album.bandName} ${album.albumName}</option>
</c:forEach>
</form:select>
<button>Add Song</button>
</form:form>
</div>

</body>
</html>