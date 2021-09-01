<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>

<%--
导入maven依赖
       <dependency>
            <groupId>javax.servlet.jsp.jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taglibs</groupId>
            <artifactId>taglibs-standard-spec</artifactId>
            <version>1.2.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.taglibs</groupId>
            <artifactId>taglibs-standard-impl</artifactId>
            <version>1.2.1</version>
        </dependency>

JSP导入标签
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>


  
  
<%--
<c:set />  作用:set标签可以往域中保存数据
    scope属性:
         page  request session appliacation
    var属性:
         设置key
    value属性:
         设置value
--%>
<c:set scope="page" var="key" value="value"></c:set>
${ pageScope.key }

  
  

<%--
<c:if />  作用:if标签用来做if判断
    test 属性表示判断的条件（使用 EL 表达式输出）
--%>
<c:set scope="page" value="100" var="number"></c:set>
<c:if test="${ number==number }">
    <h5>true</h5>
</c:if>
<c:if test="${ number!=number }">
    <h5>false</h5>
</c:if>
  
  
  
  
  
  
  
  
  
  
</body>
</html>
