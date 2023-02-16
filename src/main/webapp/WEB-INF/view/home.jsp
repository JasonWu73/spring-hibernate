<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Home Page</title>
  </head>
  <body>
    <h1>Spring Security</h1>
    <hr>
    <ul>
      <li><a href="javascript:void(0);" class="logout">Logout</a></li>
    </ul>
    <script>
      document.querySelector('.logout').addEventListener('click', async () => {
        const logoutUrl = "${pageContext.request.contextPath}/logout";
        const response = await fetch(logoutUrl, {
          method: 'POST'
        });
        if (response.ok) window.location.reload();
      });
    </script>
  </body>
</html>
