<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class= "container">
<h1>Album Details</h1>
<p>Added By:<i><a href="/profile/${albumDetails.owner.id}">${albumDetails.owner.firstName} ${albumDetails.owner.lastName}</a></i></p>
<p>Album Name: ${albumDetails.albumName} </p>
<p>Band Name: ${albumDetails.bandName} </p>
<p>Year: ${albumDetails.year} </p>
<hr>
<h3>Liked By</h3>
<ul>
<c:forEach items="${albumDetails.likers}" var = "user">
<li>${user.firstName} ${user.lastName}</li>
</c:forEach>
</ul>
<hr>
<h3>Track Listing</h3>
<c:forEach items="${albumDetails.songs}" var= "song">
<ul>
<li>${song.name} - <i>${song.length}</i> </li> 

</ul>
</c:forEach>
<hr>
<c:choose>
<c:when test="${albumDetails.owner.id ==loggedInUser}">
<a href="/edit/${albumDetails.id}">Edit</a>
<a href="/delete/${albumDetails.id}">Delete</a>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>
</div>
</body>
</html>