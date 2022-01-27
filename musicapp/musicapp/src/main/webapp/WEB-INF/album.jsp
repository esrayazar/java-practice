<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
              <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:partial>
<h5>
	Album Name:
	<c:out value="${album.albumName }" />
</h5>
<p>
	Creator:
	<c:out value="${album.user.firstName }" />
</p>
<p>
	Description:
	<c:out value="${album.description}" />
</p>
<c:if test="${album.user.id == userLoggedIn }">
<a href="/albums/delete/${album.id}">Delete</a>
<a href="/albums/edit/${album.id}">Edit</a>
</c:if>
<hr>

<%-- <p>A 
<c:out value="${album.user.id}"/></p>
<p> B <c:out value="${userLoggedIn}"/></p> --%>
<hr>
<hr>
<h5>Users who rated the show</h5>
<table class="table table-striped">
<thead>
<tr>
<th scoope="col"> User </th>
<th scoope="col"> Rating </th>
</tr>
</thead>
<c:forEach items ="${album.ratings}" var="rating">
<tr>
<td>${rating.ratedBy.firstName}</td>
<td>${rating.rating}
<c:if test="${rating.ratedBy.id == userLoggedIn}">
You have already rated!!
</c:if>
</td>
</tr>
</c:forEach>
</table>
<c:choose>
<c:when test="${album.ratings.contains(userLoggedIn)}">
You have already liked this album!!
</c:when>
<c:otherwise>
<h5 class= "text-success"> Leave a rating: </h5>
<form:form action="/albums/rateAlbum" method="post" modelAttribute ="newRating">
<div class="form-group">
	<form:label path="rating">Rating: </form:label>
	<form:input class="form-control" path="rating"/>
	<form:input type="hidden" value="${user__id}" path="ratedBy"/>
	<form:input type="hidden" value="${album.id}" path="albumRated"/>
	<input type="submit" class="btn btn-primary" value="submit"/>
</div>
</form:form>
</c:otherwise>
</c:choose> 
</t:partial>
</body>
