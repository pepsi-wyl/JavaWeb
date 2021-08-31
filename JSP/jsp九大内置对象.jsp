<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%--

内置对象

request              请求对象
pageContext          jsp的上下文对象
session              会话对象
application          ServletContext对象

response             响应对象
out                  jsp输出流对象

config               ServletConfig对象
page                 当前jsp对象
exception            异常对象

--%>


<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
4大域对象
pageContext ====> request ====> session ====> application
--%>
<%
    pageContext.setAttribute("key", "pageContext");       //当前 jsp 页面范围内有效
    request.setAttribute("key", "request");               //一次请求内有效      转发也有效
    session.setAttribute("key", "session");               //一个会话范围内有效
    application.setAttribute("key", "application");       //整个 web 工程范围内都有效
%>
<%=pageContext.getAttribute("key")%>
<%=request.getAttribute("key")%>
<%=session.getAttribute("key")%>
<%=application.getAttribute("key")%>


<%--
out 输出和 response.getWriter 输出的区别
执行out.flush()操作，把out缓冲区中的数据追加到response缓冲区末尾 ---> 执行response刷新操作，响应给客户端
out.print() ------> 把数据封装成String类型 ------> out.writer()      统一使用prinf()进行输出
--%>
<%
    out.print("wyl-out-1");
    response.getWriter().write("wyl-writer-1");

    out.flush();

    response.getWriter().write("wyl-writer-2");
    out.print("wyl-out-2");
%>
<%
  out.write(12);
  out.print(12);
%>


</body>
</html>
