<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<body>
<t:partial>

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
            <td><a href="/albums/album/${album.id}">
            <c:out value="${album.albumName}"/> </a>
            </td>
            <td>
              <c:out value="${album.user.firstName}" />
            <%--   <c:out value="${album.User.lastName}" /> --%>
            </td>
            <td>
    
            ${album.getAvarageRating()}
            
            
            </td>
          
          </tr>
        </c:forEach>
      </tbody>
    </table>
    </t:partial>
   </body>