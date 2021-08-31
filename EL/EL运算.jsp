<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>EL运算</title>
</head>
<body>


______________________________________________________________________________________________________<br>
<%--关系运算--%>
<%-- == 或 eq 等于 --%>
${ 5 == 5 } 或 ${ 5 eq 5 } true <br>
<%-- != 或 ne 不等于 --%>
${ 5 !=5 } 或 ${ 5 ne 5 } false <br>
<%-- < 或 lt 小于 --%>
${ 3 < 5 } 或 ${ 3 lt 5 } true <br>
<%-- > 或 gt 大于--%>
${ 2 > 10 } 或 ${ 2 gt 10 } false <br>
<%-- <= 或 le 小于等于 --%>
${ 5 <= 12 } 或 ${ 5 le 12 } true <br>
<%-- >= 或 ge 大于等于 --%>
${ 3 >= 5 } 或 ${ 3 ge 5 } false <br>
______________________________________________________________________________________________________<br>
<%--逻辑运算--%>
<%-- && 或 and 与运算    --%>
${ 12 == 12 && 12 < 11 } 或 ${ 12 == 12 and 12 < 11 } false <br>
<%-- || 或者 or 或运算   --%>
${ 12 == 12 || 12 < 11 } 或 ${ 12 == 12 or 12 < 11 } true <br>
<%-- ! 或者 not 取反运算  --%>
${ !true } 或 ${ not true } false <br>
______________________________________________________________________________________________________<br>
<%--算数运算--%>
<%-- + 加法 --%>
${ 12 + 18 } 30 <br>
<%-- - 减法 --%>
${ 18 - 8 } 10 <br>
<%-- * 乘法 --%>
${ 12 * 12 } 144 <br>
<%-- / 或 div 除法 --%>
${ 144 / 12 } 或 ${ 144 div 12 } 12 <br>
<%-- % 或 mod 取模 --%>
${ 144 % 10 } 或 ${ 144 mod 10 } 4 <br>
______________________________________________________________________________________________________<br>
<%--
empty运算
  值为null
  空串
  Object类型的数组长度为0
  list集合，元素个数为0
  map集合，元素个数为0
--%>
<%
    pageContext.setAttribute("emptyNull", null);   //true

    pageContext.setAttribute("emptyStr", "");      //true
    //pageContext.setAttribute("emptyStr"," ");   //false

    pageContext.setAttribute("emptyArr", new Object[]{});      //true
    //pageContext.setAttribute("emptyArr",new String[]{} );    //true
    //pageContext.setAttribute("emptyArr",new Object[]{""} );  //false

    List<String> list = new ArrayList<>();
    //list.add("");                                     //false
    pageContext.setAttribute("emptyList", list);         //true

    Map<String, Object> map = new HashMap<String, Object>();
    //map.put("key", "value");                          //false
    pageContext.setAttribute("emptyMap", map);           //true
%>
emptyNull------>${ empty emptyNull }<br>
emptyStr------->${ empty emptyStr }<br>
emptyArr------->${ empty emptyArr }<br>
emptyList------->${ empty emptyList }<br>
emptyMap------->${ empty emptyMap }<br>
______________________________________________________________________________________________________<br>
<%--三元运算--%>
${ 12 != 12 ? true:false }<br>
______________________________________________________________________________________________________<br>
<%--
"."点运算 和 [] 中括号运算符
.点运算，可以输出 Bean 对象中某个属性的值
[]中括号运算，可以输出有序集合中某个元素的值 还可以输出map集合中key里含有特殊字符的key的值
--%>
<% Map<String, Object> hashMap = new HashMap<String, Object>();
    hashMap.put("a.a", "aaaValue");
    hashMap.put("b+b+b", "bbbValue");
    hashMap.put("c-c-c", "cccValue");
    request.setAttribute("hashMap", hashMap);
%>
<%--特殊值访问--%>
${ hashMap['a.a'] } <br>



</body>
</html>
