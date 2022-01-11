<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<p>Album Name: ${albumDetails.albumName} </p>
<p>Band Name: ${albumDetails.bandName} </p>
<p>Year: ${albumDetails.year} </p>
<hr>
<c:forEach items="${albumDetails.songs}" var= "song">
<ul>
<li>${song.name} - <i>${song.length}</i> </li> 

</ul>
</c:forEach>


</div>

</body>
</html>