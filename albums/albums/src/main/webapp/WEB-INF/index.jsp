<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Welcome to Records dot Com</title>
</head>
<body>
<t:wrapper>
<h3>Welcome ${user.firstName} ${user.lastName}</h3>
<table class="table table-striped border border-dark">
<thead>
<tr>
<th>Number Of Likes</th>
<th>Album Name</th>
<th>Band Name</th>
<th>Year</th>
<th>Action</th>
</tr>
<c:forEach items= "${allAlbums}" var="album">
<tr>
<td>${album.likers.size()} </td>
<td><a href="/details/${album.id}">${album.albumName} </a></td>
<td>${album.bandName} </td>
<td>${album.year} </td>
<td>
<c:choose>
<c:when test="${album.likers.contains(user)}">
<a href="/unlike/${album.id}">Unlike</a>
</c:when>
<c:otherwise>
<a href="/like/${album.id}">Like</a>
</c:otherwise>
</c:choose> 

</tr>
</c:forEach>
</thead>
</table>

</t:wrapper> 
</body>
</html>