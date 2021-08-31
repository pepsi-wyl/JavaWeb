<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>

<%@include file="/常用标签/header.jsp"%>
<h1>main</h1>
<jsp:include page="footer.jsp">
    <jsp:param name="username" value="wyl"/>
</jsp:include>
<%--
静态包含
格式:    <%@ include file=""%>
/表示为  https://ip:port/工程路径/ 映射到代码的 web 目录
特点:
       不会翻译jsp页面 直接拷贝out输出
--%>

<%--
动态包含
格式: <jsp:include page=""></jsp:include>
特点:
     会翻译jsp页面 使用JspRuntimeLibrary.include(request, response, "footer.jsp", out, false)调用被包含的jsp页面执行输出
     可以以传递参数
底层实现原理:
     main.jsp 通过JspRuntimeLibrary.include(request, response, "footer.jsp", out, false)调用footer.jsp
     并且把request，response，out对象传递出去 (即共用一个out缓冲区)
--%>


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
