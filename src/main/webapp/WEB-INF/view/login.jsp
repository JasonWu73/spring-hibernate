<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <form:form action="${pageContext.request.contextPath}/authenticate-the-user" method="post">
      <div>
        <label for="username">Username</label>
        <input type="text" id="username" name="username">
      </div>
      <div>
        <label for="password">Password</label>
        <input type="password" id="password" name="password">
      </div>
      <div>
        <button type="submit">Log in</button>
      </div>
    </form:form>
  </body>
</html>
