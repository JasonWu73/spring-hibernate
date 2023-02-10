<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Save Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
  </head>
  <body>
    <jsp:include page="customer-header.jsp"/>

    <h2>Save Customer</h2>
    <form:form action="save" method="POST" modelAttribute="customer" cssClass="form">
      <%-- 设置 id --%>
      <form:hidden path="id"/>

      <div>
        <label for="first-name" class="form__label">First Name</label>
        <form:input path="firstName" id="first-name" cssClass="form__input"/>
        <form:errors path="firstName" cssClass="error"/>
      </div>
      <div>
        <label for="last-name" class="form__label">Last Name</label>
        <form:input path="lastName" id="last-name" cssClass="form__input"/>
        <form:errors path="lastName" cssClass="error"/>
      </div>
      <div>
        <label for="email" class="form__label">Email</label>
        <form:input path="email" id="email" cssClass="form__input"/>
        <form:errors path="email" cssClass="error"/>
      </div>
      <div>
        <button type="submit" class="button">Save</button>
        <button type="button"
                class="button button--cancel"
                onclick="window.location.href='${pageContext.request.contextPath}/customer'"
        >Back to List
        </button>
      </div>
    </form:form>
  </body>
</html>
