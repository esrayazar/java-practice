<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous"
  />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>All Projects</h1>
    <p><c:out value="${loogedIn}" /></p>
    <a href="/">Home</a>
    <a href="/projects/new">Create New Project</a>
    <a href="/dashboard">All Users</a>

    <table class="table table-dark">
      <thead>
        <tr>
          <th>Album name</th>
          <th>Created By</th>
          <th>Rating</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${albums}" var="album">
          <tr>
            <td>
              <a href="/albums/album/${album.id}">
                <c:out value="${album.albumName}"
              /></a>
            </td>
            <td>
              <c:out value="${album.User.firstName}" />,
            <%--   <c:out value="${album.User.lastName}" /> --%>
            </td>
            <td>Rating</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

</body>
</html>