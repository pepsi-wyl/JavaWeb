

package servlet;

import com.google.gson.Gson;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 *   Servlet maven配置文件
 *
 *     <dependency>
 *       <groupId>javax.servlet</groupId>
 *       <artifactId>javax.servlet-api</artifactId>
 *       <version>4.0.1</version>
 *     </dependency>
 *     
 *     
 *     
 *     <servlet>
 *       <servlet-name>ajaxServlet</servlet-name>
 *       <servlet-class>servlet.ajaxServlet</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *       <servlet-name>ajaxServlet</servlet-name>
 *       <url-pattern>/ajaxServlet</url-pattern>
 *     </servlet-mapping>
 *
 */

public class ajaxServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String method = req.getParameter("method");       //从前端获取数据
    System.out.println(method);

    if ("jQueryAjax".equals(method)) {
      this.jQueryAjax(req, resp);
    } else if ("getAjax".equals(method)) {
      this.getAjax(req, resp);
    } else if ("postAjax".equals(method)) {
      this.postAjax(req, resp);
    } else if ("getJsonAjax".equals(method)) {
      this.getJsonAjax(req, resp);
    } else if ("JavaScriptAjax".equals(method)) {
      this.JavaScriptAjax(req, resp);
    } else if ("serializeAjax".equals(method)) {
      this.serializeAjax(req, resp);
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

  private void JavaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String person_JsonStr = new Gson().toJson(new Person(1314, "wyl"));
    System.out.println(person_JsonStr);
    resp.getWriter().write(person_JsonStr);
  }

  private void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String person_JsonStr = new Gson().toJson(new Person(1314, "wyl"));
    System.out.println(person_JsonStr);
    resp.getWriter().write(person_JsonStr);
  }

  private void getAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String person_JsonStr = new Gson().toJson(new Person(1314, "wyl"));
    System.out.println(person_JsonStr);
    resp.getWriter().write(person_JsonStr);
  }

  private void postAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String person_JsonStr = new Gson().toJson(new Person(1314, "wyl"));
    System.out.println(person_JsonStr);
    resp.getWriter().write(person_JsonStr);
  }

  private void getJsonAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String person_JsonStr = new Gson().toJson(new Person(1314, "wyl"));
    System.out.println(person_JsonStr);
    resp.getWriter().write(person_JsonStr);
  }

  private void serializeAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println(req.getParameter("username") + " " + req.getParameter("password"));
  }


}
