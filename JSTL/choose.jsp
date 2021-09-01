<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>




<%--
<c:choose> <c:when> <c:otherwise>标签   多路判断 (类似switch ... case .... default)
  choose 标签开始选择判断
  when 标签表示每一种判断情况
  otherwise 标签表示剩下的情况
  test 属性表示当前这种判断情况的值
注意：
标签里不能使用 html 注释，要使用 jsp 注释
when标签的父标签一定要是choose标签
--%>
<% request.setAttribute("score", 68);%>
<c:choose>
    <c:when test="${requestScope.score<=100 && requestScope.score>90}">
        <h1>优秀</h1>
    </c:when>
    <c:when test="${requestScope.score<=90 && requestScope.score>80}">
        <h1>良好</h1>
    </c:when>
    <c:otherwise>
        <c:choose>
            <%--when标签的父标签一定要是choose标签--%>
            <c:when test="${requestScope.score<=80 && requestScope.score>70}">
                <h1>一般</h1>
            </c:when>
            <c:when test="${requestScope.score<=70 && requestScope.score>60}">
                <h1>及格</h1>
            </c:when>
            <c:otherwise>
                <h1>不及格</h1>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>






</body>
</html>
