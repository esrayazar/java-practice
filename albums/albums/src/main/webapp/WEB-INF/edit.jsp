<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Album</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<form:form method="POST" action="/edit/${album.id}" modelAttribute="album">
<form:label path="albumName">Album Name</form:label>
<form:errors path="albumName"/>
<form:input type="text" path="albumName"/>
<form:label path="bandName">Band Name</form:label>
<form:errors path="bandName"/>
<form:input type="text" path="bandName"/>
<form:label path="year">Year</form:label>
<form:errors path="year"/>
<form:input type="text" path="year"/>
<p><button>Edit Album</button>
</form:form>

</body>
</html>