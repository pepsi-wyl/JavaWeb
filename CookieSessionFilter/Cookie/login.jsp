<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie_session_filter</title>
</head>
<body>
<form action="http://localhost/cookie_session_filter/loginServlet" method="post">
    <input type="text" name="username" value="${ cookie.username.value }"> <br/>
    <input type="password" name="password"> <br/>
    <input type="submit" value="登陆"> <br/>
</form>
</body>
</html>
