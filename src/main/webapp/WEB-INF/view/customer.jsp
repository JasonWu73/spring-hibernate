<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>List Customers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
  </head>
  <body>
    <jsp:include page="customer-header.jsp"/>

    <nav class="nav">
      <button class="button" onclick="window.location.href='customer/form-add'">Add Customer</button>
    </nav>

    <table class="table">
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Action</th>
      </tr>
      <c:forEach items="${customers}" var="customer">
        <%-- 定义更新/删除 URL 变量 --%>
        <c:url var="updateLink" value="/customer/form-update">
          <c:param name="customerId" value="${customer.id}"/>
        </c:url>
        <c:url var="deleteLink" value="/customer/delete">
          <c:param name="customerId" value="${customer.id}"/>
        </c:url>

        <tr>
          <td>${customer.firstName}</td>
          <td>${customer.lastName}</td>
          <td>${customer.email}</td>
          <td><a href="${updateLink}">Update</a></td>
          <td><a href="${deleteLink}" class="customer-delete">Delete</a></td>
        </tr>
      </c:forEach>
    </table>

    <script>
      (() => {
        const customerDeleteElements = document.querySelectorAll('.customer-delete');
        for (let i = 0, len = customerDeleteElements.length; i < len; i++) {
          customerDeleteElements[i].addEventListener('click', e => {
            const isSure = confirm('Are you sure to delete customer?');
            if (isSure) return true;

            e.preventDefault();
            return false;
          });
        }
      })();
    </script>
  </body>
</html>
