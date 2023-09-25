<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 19.09.2023
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My page</title>
</head>
<body>
<%
    String user = null;
    String sessionUser = (String) session.getAttribute("username");
    if (sessionUser == null) {
        response.sendRedirect("login");
    }
    else {
        user = sessionUser;
    }

    String cookieUser = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equalsIgnoreCase(cookie.getName())) {
                cookieUser = cookie.getValue();
            } else if ("jsessionid".equalsIgnoreCase(cookie.getName())) {
                sessionId = cookie.getValue();
            }
        }
    } else {
        sessionId = session.getId();
    }
%>

<h3>
   Hello, <%=user%>! Login successful
    <br>
    Session ID = <%=sessionId%>
    <br>
    Cookie username = <%=cookieUser%>
</h3>
</body>
</html>
