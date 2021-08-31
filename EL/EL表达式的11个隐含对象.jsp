<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式的11个隐含对象</title>
</head>
<body>





<%--
EL表达式的11个隐含对象

pageContext         PageContextImpl        它可以获取 jsp 中的九大内置对象

pageScope           Map<String,Object>     它可以获取 pageContext 域中的数据
requestScope        Map<String,Object>     它可以获取 Request 域中的数据
sessionScope        Map<String,Object>     它可以获取 Session 域中的数据
applicationScope    Map<String,Object>     它可以获取 ServletContext 域中的数据

param               Map<String,String>     它可以获取请求参数的值
paramValues         Map<String,String[]>   它也可以获取请求参数的值，获取多个值的时候使用

header              Map<String,String>     它可以获取请求头的信息
headerValues        Map<String,String[]>   它可以获取请求头的信息，它可以获取多个值的情况

cookie              Map<String,Cookie>     它可以获取当前请求的 Cookie 信息

initParam           Map<String,String>     它可以获取在 web.xml 中配置的<context-param>上下文参数

--%>


<%--
EL获取四个特定域中的属性

pageScope           Map<String,Object>     它可以获取 pageContext 域中的数据         pageContext 域
requestScope        Map<String,Object>     它可以获取 Request 域中的数据             Request 域
sessionScope        Map<String,Object>     它可以获取 Session 域中的数据             Session 域
applicationScope    Map<String,Object>     它可以获取 ServletContext 域中的数据      ServletContext 域
--%>
<%
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext ------> ${ pageScope.key }<br>
request------> ${ requestScope.key }<br>
session------> ${ sessionScope.key }<br>
application------> ${ applicationScope.key }<br>




<%--
pageContext对象的使用
--%>
<%--
request.getScheme()        获取请求的协议
request.getServerName()    获取请求的服务器ip或域名
request.getServerPort()    获取请求的服务器端口号
getContextPath()           获取当前工程路径
request.getMethod()        获取请求的方式（GET 或 POST）
request.getRemoteHost()    获取客户端的 ip 地址
session.getId()            获取会话的唯一标识
--%>
<% pageContext.setAttribute("req", request); %>
协议------> ${ req.scheme }<br>
服务器 ip------> ${ pageContext.request.serverName }<br>
服务器端口------> ${ pageContext.request.serverPort }<br>
工程路径------> ${ pageContext.request.contextPath }<br>
请求方法------> ${ pageContext.request.method }<br>
客户端ip地址------> ${ pageContext.request.remoteHost }<br>
会话的id编号------> ${ pageContext.session.id }<br>




<%--
param               Map<String,String>     它可以获取请求参数的值
paramValues         Map<String,String[]>   它也可以获取请求参数的值，获取多个值的时候使用
--%>
${ param.username }<br>
${ param.password }<br>
${ paramValues.username[0]}<br>    <!--也可以获取一个参数-->
${ paramValues.habby[0] }<br>
${ paramValues.habby[1] }<br>
<%--http://192.168.1.6/jsp/EL/EL%E8%A1%A8%E8%BE%BE%E5%BC%8F%E7%9A%8411%E4%B8%AA%E9%9A%90%E5%90%AB%E5%AF%B9%E8%B1%A1.jsp?username=zhazha&password=888888&habby=java&habby=cpp--%>




<%--
header              Map<String,String>     它可以获取请求头的信息
headerValues        Map<String,String[]>   它可以获取请求头的信息，它可以获取多个值的情况
--%>
${ header.Connection }<br>
${ headerValues['User-Agent'][0]}<br>




<%--
cookie              Map<String,Cookie>     它可以获取当前请求的 Cookie 信息
--%>
${ cookie.JSESSIONID.name }<br>
${ cookie.JSESSIONID.value }<br>




<%--
initParam           Map<String,String>     它可以获取在 web.xml 中配置的<context-param>上下文参数
--%>
<%--
web.xml中配置
<context-param>
        <param-name>username</param-name>
        <param-value>zhazha</param-value>
</context-param>
--%>
${ initParam.username }<br>




</body>
</html>
