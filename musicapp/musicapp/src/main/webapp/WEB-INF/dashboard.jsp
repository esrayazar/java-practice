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
<h2>Hi ${user.firstName} ${user.lastName} </h2>
<hr>
<form:form method="POST" action="/albums/addalbums" modelAttribute="album">
<form:errors path="description"/>
<form:textarea path="description" placeholder="Post a Great album Here!"/>
<button>Add Album</button>
</form:form>
<hr>
<c:forEach items="${allalbums}" var="album">
<%-- <p>
<c:choose>
<c:when test="${album.likers.contains(user)}">
<a href="/albums/${album.id}/unlike ">Unlike </a>

</c:when>
<c:otherwise>
<a href="/albums/${album.id}/like ">Like </a>
</c:otherwise>
</c:choose>

</p> --%>
<p>${album.user.firstName} says: ${album.description}</p>
<p><a href="/${album.id}">Details</a> | ${album.likers.size()}
<p><c:if test="${album.user.id==user.id}">
<a href="/${album.id}/delete">Delete</a>
</c:if>
</c:forEach>


</body>
</html>