<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello World - Confirmation Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/p.css">
  </head>
  <body>
    <h1>Hello World of Spring!</h1>
    <p>Student Name: ${param.studentName}</p>
    <p>The Message: ${message}</p>
  </body>
</html>