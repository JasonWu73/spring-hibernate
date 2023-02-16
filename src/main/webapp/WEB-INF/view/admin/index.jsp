<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Admin Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
  </head>
  <body>
    <h1>Admin Page</h1>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
      <button type="submit">Logout</button>
    </form:form>
  </body>
</html>
