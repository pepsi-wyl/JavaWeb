
<%@ page contentType="text/html;charset=UTF-8"
         import="Bean.student"
         language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<html>
<head>
    <title>EL表达式</title>
</head>
<body>

<%--
EL 表达式    (Expression Language)
作用:代替jsp页面中的表达式脚本在jsp页面中进行数据的输出

EL表达式在输出 null 值的时候，输出的是空串
jsp表达式脚本输出 null 值的时候，输出的是 null 字符串

--%>
<% request.setAttribute("k", "value"); %>
表达式脚本输出 key 的值是:<%=request.getAttribute("k") == null ? "" : request.getAttribute("k")%> <br/>
EL 表达式输出 key 的值是:${ k } <br/>


<%--
EL表达式搜索域数据的顺序
从小到大的顺序去进行搜索
--%>
<%
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
    pageContext.setAttribute("key", "pageContext");
%>
${ key }


<%--
EL表达式输出Bean的普通属性 数组属性 List集合属性 Map集合属性
--%>
<%
    //创建对象
    student s = new student();
    //设置普通类型属性
    s.setId(2015105456);
    //设置字符串类型属性
    s.setName("wyl");
    //设置字符串数组类型属性
    s.setPhones(new String[]{"13673330837", "13673333088", "13673333999"});
    //设置list属性
    ArrayList<String> lists = new ArrayList<>();
    lists.add("上海");
    lists.add("北京");
    lists.add("郑州");
    s.setLists(lists);
    //设置map属性
    Map<String, Object> maps = new HashMap<>();
    maps.put("key1", "value1");
    maps.put("key2", "value2");
    maps.put("key3", "value3");
    s.setMaps(maps);
    //设置域属性
    pageContext.setAttribute("student", s);
%>
<%--[]可以取数组或者list中的元素 .可以取map或者对象的属性元素--%>
Student:${student}<br>
Student--->ID:${student.id}<br>
Student--->name:${student.name}<br>
Student--->phones:${student.phones}<br>
Student--->phone:${student.phones[1]}<br>
Student--->lists:${student.lists}<br>
Student--->list:${student.lists[1]}<br>
Student--->maps:${student.maps}<br>
Student--->map:${student.maps.key2}<br>


</body>
</html>


