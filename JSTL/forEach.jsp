<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="Bean.person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>




<%--
<c:forEach />
    begin 属性设置开始的索引
    end 属性设置结束的索引
    step 属性表示遍历的步长值  (默认为1)
    items 表示遍历的集合
    var 属性表示循环的变量(也是当前正在遍历到的数据)
    varStatus 属性表示当前遍历到的数据的状态
--%>

<%--遍历1到10输出  递增为2--%>
<c:forEach begin="1" end="10" var="number" step="2">
    ${ number }
</c:forEach>
<br/>

<%--varStatus--%>
<c:forEach begin="1" end="10" var="number" step="2" varStatus="status">
    ${ number }<br/>
    ${ status.current }    //获取当前的数据<br/>
    ${ status.index }      //获取当前遍历的索引<br/>
    ${ status.count }      //获取当前遍历的个数<br/>
    ${ status.first }      //是否为第一个<br/>
    ${ status.last }       //是否为最后一个<br/>
    ${ status.begin }      //获取begin值<br/>
    ${ status.end }        //获取end值<br/>
    ${ status.step }       //获取step值<br/>
</c:forEach>

<%--遍历Object数组--%>
<%
    request.setAttribute("StringArr", new String[]{"StringArr",});
%>
<c:forEach items="${ requestScope.StringArr }" var="item">
    ${ item } <br/>
</c:forEach>

<%--遍历List集合--%>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("list");
    request.setAttribute("list", list);
%>
<c:forEach items="${ requestScope.list }" var="list">
    ${ list } <br/>
</c:forEach>

<%--遍历Map集合--%>
<%
    Map<String, String> map = new HashMap<>();
    map.put("key", "value");
    request.setAttribute("map", map);
%>
<c:forEach items="${ requestScope.map }" var="map">
    ${ map.key } ${ map.value }<br/>
</c:forEach>

<%--遍历List集合中的对象数据--%>
<%
    ArrayList<person> peoples = new ArrayList<>();
    peoples.add(new person(1, "wyl", 20, "13673330837"));
    peoples.add(new person(2, "wyl", 20, "13673330837"));
    request.setAttribute("peoples", peoples);
%>
<table bgcolor="#ffc0cb" border="1px" >
    <th><td>id</td><td>name</td><td>age</td><td>phone</td></th>
    <c:forEach items="${ requestScope.peoples }" var="people">
        <tr>
            <td>${ people.id }</td>
            <td>${ people.name }</td>
            <td>${ people.age }</td>
            <td>${ people.phone }</td>
            <td> 操作 </td>
        </tr>
    </c:forEach>
</table>





</body>
</html>

