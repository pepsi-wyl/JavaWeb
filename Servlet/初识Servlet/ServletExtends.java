

package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;



/**
 *
 * extends HttpServlet
 *
 *
 * 使用注解可以省去 web.xml中Servlet的注册
 *
 * Servlet 类的继承体系
 *   自定义类->HttpServlet->GenericServlet->Servlet
 *   Servlet接口 负责定义Servlet程序的访问规范
 *   GenericServlet类 实现了Servlet接口 做了很多空实现 并持有一个ServletConfig类的引用并对ServletConfig的使用做一些方法
 *   HttpServlet抽取了Service()方法 并实现了请求的分发   doGet/doPost方法负责抛异常
 *   自定义类 重写doGet/doPost方法，实现业务逻辑

 */
@WebServlet(name = "ServletExtends", value = "/ServletExtends")

public class ServletExtends extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("ServletExtends");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
