# javaweb_T

package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * implements  Servlet   编写service方法
 *
 *
 * 一：在web.xml 文件中注册
 * <!--注册servlet_Hello-->
 * <!-- servlet 标签给 Tomcat 配置 Servlet 程序 -->
 * <servlet>
 * <!--servlet-name 标签 Servlet 程序起一个别名（一般是类名） -->
 * <servlet-name>servletHello</servlet-name>
 * <!--servlet-class 是 Servlet 程序的全类名-->
 * <servlet-class>servlet.servletHello</servlet-class>
 * </servlet>
 * <!--servlet-mapping 标签给 servlet 程序配置访问地址-->
 * <servlet-mapping>
 * <!--servlet-name 标签的作用是告诉服务器，我当前配置的地址给哪个 Servlet 程序使用-->
 * <servlet-name>servletHello</servlet-name>
 * <!--url-pattern 标签配置访问地址  / 斜杠在服务器解析的时候，表示地址为：http://ip:port/工程路径> -->
 * <url-pattern>/hello</url-pattern>
 * </servlet-mapping>
 * 常见错误 1：url-pattern   中配置的路径没有以斜杠打头。
 * 常见错误 2：servlet-name  配置的值不存在(不一致)。
 * 常见错误 3：servlet-class 标签的全类名配置错误。
 *
 *
 * 二：url 地址到 Servlet 程序的访问
 * http://localhost:8080/Servlet/servlet_Hello
 * http://     表示 http协议
 * localhost   表示 服务器IP           确定的电脑
 * :8080       表示 服务器端口号        确定TomCat服务器
 * /Servlet    表示 工程路径            确定工程
 * /servletHello  表示资源路径         mapping:url-pattern  ->  mapping:servlet-name  ->  servlet:servlet-name  ->  servlet:servlet-class
 *
 *
 * 三：Servlet 的生命周期
 * 1、执行 Servlet 构造器方法
 * 2、执行 init 初始化方法       1和2 在第一次访问的时候创建Servlet是调用
 * 3、执行 service 方法         3 每次访问都会调用。
 * 4、执行 destroy 销毁方法     4 web 工程停止的时候调用
 *
 *
 * 四：GET 和 POST 请求的分发处理
 * String method=((HttpServletRequest)servletRequest).getMethod();
 *
 */
public class servletHello implements Servlet {

  public servletHello() {
    System.out.println("1、执行 Servlet 构造器方法");
  }

  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("2、执行 init 初始化方法");
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("3、执行 service 方法");
    System.out.println("HelloServlet!");

    // GET 和 POST 请求的分发处理
    String method = ((HttpServletRequest) servletRequest).getMethod();    //向下转型得到子类中的getMethod方法
    System.out.println(method);
    if ("GET".equals(method)) {
      this.doGet();
    } else if ("POST".equals(method)) {
      this.doPost();
    }

  }

  //Get请求
  private void doGet() {
    System.out.println("Get请求");
  }

  //Post请求
  private void doPost() {
    System.out.println("Post请求");
  }

  @Override
  public void destroy() {
    System.out.println("4、执行 destroy 销毁方法");
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public String getServletInfo() {
    return null;
  }

}

