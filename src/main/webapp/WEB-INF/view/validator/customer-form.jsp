<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Customer Registration Form</title>
    <style>
      .error {
        color: red;
      }
    </style>
  </head>
  <body>
    <h2>Fill out the form. Asterisk (*) means required.</h2>
    <form:form action="process-form" method="POST" modelAttribute="customer">
      <div>
        <label>First Name: <form:input path="firstName"/></label>
      </div>
      <div>
        <label>Last Name(*): <form:input path="lastName"/></label>
        <form:errors path="lastName" cssClass="error"/>
      </div>
      <div>
        <label>Free Passes: <form:input path="freePasses"/></label>
        <form:errors path="freePasses" cssClass="error"/>
      </div>
      <div>
        <label>Postal Code: <form:input path="postalCode"/></label>
        <form:errors path="postalCode" cssClass="error"/>
      </div>
      <div>
        <label>Course Code: <form:input path="courseCode"/></label>
        <form:errors path="courseCode" cssClass="error"/>
      </div>
      <div>
        <button type="submit">Submit</button>
      </div>
    </form:form>
  </body>
</html>
