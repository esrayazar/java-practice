<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<t:wrapper>
<h2>Details For ${user.firstName} ${user.lastName}</h2>
<hr>
<h3>Album Added</h3>
<ul>
<c:forEach items="${user.myAlbums}" var="album">
<li><a href="/details/${album.id}">${album.bandName} - ${album.albumName}</a>
</c:forEach>
</ul>

</t:wrapper>
</body>
</html>