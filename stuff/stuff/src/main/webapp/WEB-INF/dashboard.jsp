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
<form:form method="POST" action="/thoughts/addThought" modelAttribute="thought">
<form:errors path="description"/>
<form:textarea path="description" placeholder="Post a Great Thought Here!"/>
<button>Add Thought</button>
</form:form>
<hr>
<c:forEach items="${allThoughts}" var="thought">
<p>
<c:choose>
<c:when test="${thought.likers.contains(user)}">
<a href="/thoughts/${thought.id}/unlike ">Unlike </a>

</c:when>
<c:otherwise>
<a href="/thoughts/${thought.id}/like ">Like </a>
</c:otherwise>
</c:choose>

</p>
<p>${thought.user.firstName} says: ${thought.description}</p>
<p><a href="/${thought.id}">Details</a> | ${thought.likers.size()}
<p><c:if test="${thought.user.id==user.id}">
<a href="/${thought.id}/delete">Delete</a>
</c:if>
</c:forEach>


</body>
</html>