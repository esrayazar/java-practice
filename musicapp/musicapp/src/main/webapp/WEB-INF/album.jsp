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

    

</t:partial>
</body>
