package ServletConfig_Context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * web.xml配置
 *  <servlet>
 *     <servlet-name>servletConfig_Context_E</servlet-name>
 *     <servlet-class>ServletConfig_Context.servlet_E</servlet-class>
 *     <init-param>
 *       <param-name>username</param-name>
 *       <param-value>zhazha</param-value>
 *     </init-param>
 *   </servlet>
 *   <servlet-mapping>
 *     <servlet-name>servletConfig_Context_E</servlet-name>
 *     <url-pattern>/servletConfig_Context_E</url-pattern>
 *   </servlet-mapping>
 *
 *
 * web.xml中配置
 *  <context-param>
 *     <param-name>username</param-name>
 *     <param-value>zhazha</param-value>
 *  </context-param>
 *
 */

public class servlet_E extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);     //一定要调用父类的int(config)操作
    System.out.println("servlet初始化");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //ServletConfig类的三大作用
    System.out.println("别名: " + getServletConfig().getServletName());                         //获取 Servlet 程序的别名 servlet-name 的值
    System.out.println("username: " + getServletConfig().getInitParameter("username"));      //获取初始化参数 init-param
    System.out.println("ServletContext对象: "+getServletConfig().getServletContext());          //获取 ServletContext 对象

    //ServletContext 类的四个作用
    System.out.println(getServletContext().getInitParameter("username")); //获取 web.xml 中配置的上下文参数 context-param
    System.out.println(getServletContext().getContextPath());                //获取当前的工程路径，格式: /工程路径
    System.out.println(getServletContext().getRealPath("/"));              //获取工程部署后在服务器硬盘上的绝对路径
    System.out.println(getServletContext().getRealPath("/index.jsp"));     //获取工程部署后在服务器硬盘上的绝对路径
    //像Map一样存取数据
    System.out.println(getServletContext().getAttribute("name"));

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
