<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Student Confirmation</title>
  </head>
  <body>
    <p>The student is confirmed: ${student.firstName} ${student.lastName}</p>
    <p>Country: ${student.country}</p>
    <p>Favorite language: ${student.favoriteLanguage}</p>
    <p>Operating Systems:</p>
    <ul>
      <c:forEach var="item" items="${student.operatingSystems}">
        <li>${item}</li>
      </c:forEach>
    </ul>
  </body>
</html>
