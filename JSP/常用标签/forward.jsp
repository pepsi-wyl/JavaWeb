<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward</title>
</head>
<body>

<%--
请求转发
格式:  <jsp:forward page=""></jsp:forward>
--%>
<jsp:forward page="../T_1.jsp"></jsp:forward>
    
<%
    //1.前端
    //pageContext.forward("../T_1.jsp");
    //2.后端
    //request.getRequestDispatcher("../T_1.jsp").forward(request, response);
%>

</body>
</html>
