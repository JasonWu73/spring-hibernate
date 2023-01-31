<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Student Form</title>
  </head>
  <body>
    <form:form action="process-form" method="POST" modelAttribute="student">
      <label>First Name: <form:input path="firstName"/></label>
      <label>Last Name: <form:input path="lastName"/></label>
      <button type="submit">Submit</button>
    </form:form>
  </body>
</html>
