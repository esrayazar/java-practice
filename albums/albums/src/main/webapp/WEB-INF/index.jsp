<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%><!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Welcome to Records dot Com</title>
</head>
<body>
<div class="controller">
<h1>Welcome To Record dot Com</h1>
<hr>
<a href="/new">Add an Album</a>  |  <a href="/songs/new">Add an Album</a> 
<table class="table table-striped table-dark">
<thead>
<tr>
<th>Id</th>
<th>Album Name</th>
<th>Band Name</th>
<th>Year</th>
</tr>
<c:forEach items= "${allAlbums}" var="album">
<tr>
<td>${album.id} </td>
<td><a href="/details/${album.id}">${album.albumName} </a></td>
<td>${album.bandName} </td>
<td>${album.year} </td>
</tr>
</c:forEach>
</thead>
</table>






</div >
</body>
</html>