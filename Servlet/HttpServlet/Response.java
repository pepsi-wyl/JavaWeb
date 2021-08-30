package HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletResponse类
 * Tomcat服务器封装Response对象(表示响应的信息)   -------> 传递到 service方法中(doGet/doPost)
 * http://127.0.0.1/servlet/Response
 */


@WebServlet(name = "Response", value = "/Response")          //注解免去web.xml中配置
public class Response extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    /**
     * 响应乱码问题
     */
    resp.setCharacterEncoding("utf-8");          //设置服务器响应的字符集类型
    //设置浏览器响应的字符集类型
    //方式一:
    resp.setHeader("Content-Type", "text/html; charset=UTF-8");
    //方式二：(常用)
    resp.setContentType("text/html; charset=UTF-8");


    /**
     * 两个输出流(客户端回传数据)
     * 字节流 getOutputStream(); 常用于下载（传递二进制数据）
     * 字符流 getWriter(); 常用于回传字符串（常用）
     * 注意：两个流同时只能使用一个，否则报错
     */
    resp.getWriter().write("Response!");   //客户端回传数据


    /**
     * 请求重定向
     * 服务器收到请求后，返回一个新的地址
     * 特点：
     *   浏览器地址栏发生变化
     *   是两次次请求，共享Request域中的数据
     *   不可以转发到WEB-INF下
     *   可以访问工程以外的资源(工程内的任何资源都可以访问 servlet,jsp,html......)
     */
    //方式一：
    //resp.setStatus(302);
    //resp.setHeader("Location","https://www.baidu.com");
    //方式二：(常用)
    resp.sendRedirect("https://www.baidu.com");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
