package Servlet;

import utils.CookieUtils;
import utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie 是服务器通知客户端保存键值对的一种技术
 * 客户端有了 Cookie 后，每次请求都发送给服务器
 * 每个 Cookie 的大小不能超过 4kb
 */

@WebServlet(name = "cookieServlet", value = "/cookieServlet")
public class cookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");
        if (!StringUtil.isEmpty(method)) {
            switch (method) {
                case "creatCookie" -> this.creatCookie(req, resp);
                case "getCookie" -> this.getCookie(req, resp);
                case "modifyCookie" -> this.modifyCookie(req, resp);
                case "deleteCookie" -> this.deleteCookie(req, resp);
                case "setCookieTime" -> this.setCookieTime(req, resp);
                default -> System.out.println("error");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * creatCookie
     */
    private void creatCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("creatCookie!");
        Boolean cookie1 = CookieUtils.creatCookie("key1", "value1", resp);
        resp.getWriter().write(cookie1 == true ? "Cookie1创建成功!" : "Cookie1创建失败!" + "<br/>");
        Boolean cookie2 = CookieUtils.creatCookie("key2", "value2", 60 * 60, resp);
        resp.getWriter().write(cookie2 == true ? "Cookie2创建成功!" : "Cookie2创建失败!" + "<br/>");
    }

    /**
     * getCookie
     * req.getCookies():Cookie[]   得到Cookie
     * getName()     得到CookieKey
     * getValue()    得到CookieValue
     */
    private void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getCookie!");
        Cookie[] cookies = CookieUtils.getCookies(req);
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]" + "<br/>");
        }
        Cookie cookie = CookieUtils.findCookie(cookies, "key1");
        resp.getWriter().write(cookie == null ? "没有找到" : "找到了" + "<br/>");
    }

    /**
     * modifyCookie
     * 找到Cookie进行修改  /进行覆盖
     */
    private void modifyCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("modifyCookie!");
        Boolean flag = CookieUtils.modifyCookie("key1", "value+value", req, resp);
        resp.getWriter().write(flag == true ? "修改成功!" : "修改失败!" + "<br/>");
    }


    /**
     * 删除Cookie
     * setMaxAge=0
     */
    private void deleteCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("deleteCookie!");
        Boolean flag = CookieUtils.deleteCookie("key1", req, resp);
        resp.getWriter().write(flag == true ? "删除成功!" : "删除失败!" + "<br/>");
    }

    /**
     * setCookieTime
     */
    private void setCookieTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("setCookieTime!");
        Boolean flag = CookieUtils.setCookieTime("key1", 60 * 60, req, resp);
        resp.getWriter().write(flag == true ? "设置成功!" : "设置失败!" + "<br/>");
    }

}
