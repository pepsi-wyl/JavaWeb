# javaweb_T

<%--
jsp(java server pages) java的服务器页面
作用:代替servlet程序回传HTML页面数据 (Servlet回传HTML数据繁琐)
访问:jsp页面和html页面一样都是存放在web目录下 访问跟访问html页面一样
本质:Servlet程序  第一次访问jsp页面时，Tomcat服务器把jsp页面翻译成java源文件，并编译成class字节码程序
    通过输出流，把html页面数据回传给客户端
--%>


<%--
page指令(修改jsp页面的重要属性和行为)

contentType="text/html;charset=UTF-8"   //jsp返回的数据类型
pageEncoding="utf-8"                    //jsp页面的字符集 默认utf-8
language="java"                         //jsp翻译后的语言 暂时只能是java
import="java.util.Arrays"               //导入包和类

autoFlush="true"              //当out输出流缓冲区满，是否自动刷新  默认true  (JSP Buffer overflow)
buffer="8kb"                  //设置out输出流缓冲区大小    默认8kb

errorPage="/500.jsp"          //当前jsp页面错误，自动跳转的页面   (/打头，表示地址为http://ip:port/工程路径)
isErrorPage="false"           //当前页面是否为错误页面 默认为false  true时可以捕捉异常信息

session="true"          //访问当前jsp页面是否会创建HttpSession对象     默认为true
extends=""              //当前jsp页面翻译出来继承谁
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        pageEncoding="utf-8"
        language="java"
        import="java.util.HashMap"

        autoFlush="true"
        buffer="8kb"

        errorPage="/500.jsp"
        isErrorPage="false"

        session="true"
%>


<html>
<head>
    <title>JSP</title>
</head>
<body>





<%--
声明脚本                         极少使用
格式：<%! 声明 java 代码 %>
作用:定义属性，方法，静态代码块，内部类等
--%>
<%--声明类属性--%>
<%!
    private static int id;
    private String name;
%>
<%--声明类方法--%>
<%!
    public void fun() {
        System.out.println("fun方法");
    }
%>
<%--声明static静态代码块--%>
<%!
    static {
        id = 2015;
    }
%>
<%--声明内部类--%>
<%!
    public static class son {
        private Integer id = 123456;
        private String abc = "son";
    }
%>


<%--
表达式脚本                           常用
格式:<%=表达式%>
作用:jsp 页面上输出数据
特点:
   表达式不能以分号结束
   表达式脚本翻译到_jspService() 方法   即_jspService()方法中的对象都可以直接使用
   表达式脚本翻译成out.print()输出到页面上
--%>
<%=10%>   <br/>
<%=10.01%>   <br/>
<%="表达式脚本"%>   <br/>
<%=new HashMap<>()%>  <br/>


<%--
代码脚本
格式:<% java 语句 %>
作用:在 jsp页面中，编写我们自己需要的功能（写的是 java 语句）
特点:
   可以由多个代码脚本块组合完成一个完整的java语句
   可以和表达式脚本一起组合使用，在jsp页面上输出数据
   代码脚本翻译到_jspService() 方法   即_jspService()方法中的对象都可以直接使用
--%>
<%
    for (int i = 1; i <= 10; i++) {
%>
<%=i%>  <br/>
<%
    }
%>






<%--
注释
--%>
<!-- 这是 html 注释 -->                         <%--html 注释会被翻译到 java 源代码--%>
<% // 单行 java 注释 /* 多行 java 注释 */ %>      <%--java 注释会被翻译到 java 源代码--%>
<%-- 这是 jsp 注释 --%> <%--jsp 注释可以注掉，jsp 页面中所有代码--%>





</body>
</html>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
</head>
<body>
500错误
</body>
</html>
