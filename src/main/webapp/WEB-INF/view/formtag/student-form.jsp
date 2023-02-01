<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Student Form</title>
  </head>
  <body>
    <form:form action="process-form" method="POST" modelAttribute="student">
      <p><label>First Name: <form:input path="firstName"/></label></p>
      <p><label>Last Name: <form:input path="lastName"/></label></p>
      <p>Country:
        <form:select path="country">
          <form:options items="${countryOptions}"/>
        </form:select>
      </p>
      <p>Favorite Language:</p>
      <p>
        <form:radiobutton path="favoriteLanguage" value="Java"/> Java
        <form:radiobutton path="favoriteLanguage" value="C#"/> C#
        <form:radiobutton path="favoriteLanguage" value="PHP"/> PHP
        <form:radiobutton path="favoriteLanguage" value="Ruby"/> Ruby
      </p>
      <p>Operating Systems:</p>
      <p>
        <form:checkbox path="operatingSystems" value="Linux"/> Linux
        <form:checkbox path="operatingSystems" value="Mac OS"/> Mac OS
        <form:checkbox path="operatingSystems" value="MS Windows"/> MS Windows
      </p>
      <button type="submit">Submit</button>
    </form:form>
  </body>
</html>
