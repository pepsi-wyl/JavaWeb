package HttpServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * HttpServletRequest类
 * Tomcat服务器会把请求过来的Http协议信息解析封装到Request对象中 (表示请求过来的信息) -------> 传递到 service方法中(doGet/doPost)
 * http://127.0.0.1/servlet/Request?parameter=wyl&parameters=wyl&parameters=bsy
 */

/**
 * web 中 / 斜杠的不同意义 (绝对路径)
 *
 * / 斜杠 浏览器解析
 * 得到的地址是：http://ip:port/
 * 1.<a href="/">斜杠</a>   可以设置相对base路径使用相对路径<base href="http://localhost/servlet/">
 *
 * / 斜杠 服务器解析
 * 得到的地址是：http://ip:port/工程路径
 * 1.<url-pattern>/servlet</url-pattern>
 * 2.servletContext.getRealPath("/");
 * 3.request.getRequestDispatcher("/");
 * 特殊情况： response.sendRedirect("/");(重定向 发送给浏览器)   把斜杠发送给浏览器解析得到 http://ip:port/
 */

@WebServlet(name = "Request", value = "/Request")          //注解免去web.xml中配置
public class Request extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /**
     * 解决中文乱码问题
     * new String(req.getParameter("XXX").getBytes("iso-8859-1"), "UTF-8");
     * request.setCharacterEncoding("utf-8");
     */
    //设置服务器请求的字符集类型
    request.setCharacterEncoding("utf-8");

    /**
     * HttpServletRequest类中常用方法
     */
    System.out.println("URI => " + request.getRequestURI());                            //请求的资源路径
    System.out.println("URL => " + request.getRequestURL());                            //请求的统一资源定位符(绝对路径)
    System.out.println("客户端IP => " + request.getRemoteHost());                        //客户端的IP地址
    System.out.println("请求头 User-Agent => " + request.getHeader("User-Agent"));       //请求头中的信息(浏览器信息)
    System.out.println("method => " + request.getMethod());                             //请求的类型

    //获取前端参数
    System.out.println("parameter => " + request.getParameter("parameter"));                          //获取name唯一的参数
    System.out.println("parameters => " + Arrays.asList(request.getParameterValues("parameters")));    //获取name不唯一的参数

    //域数据
    request.setAttribute("key", "value");                           //设置域数据
    System.out.println(request.getAttribute("key"));                   //获取域数据

    /**
     * 请求转发
     * 服务器收到请求后，从一次资源跳转到另一个资源的操作
     * 特点：
     *   浏览器地址栏没有变化
     *   是一次请求，共享Request域中的数据
     *   可以转发到WEB-INF下
     *   不可以访问工程以外的资源(工程内的任何资源都可以访问 servlet,jsp,html......)
     */
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);
  }
}
