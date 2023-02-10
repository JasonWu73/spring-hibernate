<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>List Customers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
  </head>
  <body>
    <header class="header">
      <h1 class="header__title">CRM - Customer Relationship Manager</h1>
    </header>

    <nav class="nav">
      <button class="button">Add Customer</button>
    </nav>

    <table class="table">
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
      </tr>
      <c:forEach items="${customers}" var="customer">
        <tr>
          <td>${customer.firstName}</td>
          <td>${customer.lastName}</td>
          <td>${customer.email}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
