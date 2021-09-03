package Servlet;

import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Session 就一个接口（HttpSession） 会话
 * 用来维护一个客户端和服务器之间关联的一种技术  每个客户端都有自己的一个 Session 会话
 * Session 会话中，我们经常用来保存用户登录之后的信息
 */

/**
 * 客户端没有session-cookie的情况下请求服务器服务器会创建新的Session(存在与服务器内存中) ------> 将sessionID发送到客户端的cookie保存------>返回session对象
 * 客户端有session-cookie的情况下请求服务器------>查找session对象------>返回session对象
 */

@WebServlet(name = "sessionServlet", value = "/sessionServlet")
public class sessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        System.out.println(method);
        if (!CookieUtils.isEmpty(method)) {
            switch (method) {
                case "creatSession" -> this.creatSession(req, resp);
                case "setAttribute" -> this.setAttribute(req, resp);
                case "getAttribute" -> this.getAttribute(req, resp);
                case "getTime" -> this.getTime(req, resp);
                case "setTime_3" -> this.setTime_3(req, resp);
                case "setTime_0" -> this.setTime_0(req, resp);
                default -> System.out.println("error");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    /**
     * creatSession
     */
    protected void creatSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("creatSession!");
        /**
         * request.getSession() 第一次调用时creat 之后都是get
         */
        HttpSession session = req.getSession();

        /**
         * isNew()   true 表示刚创建    false 表示获取之前创建
         */
        boolean flag = session.isNew();
        resp.getWriter().write(flag == true ? "new" : "old");

        /**
         * getId() 得到 Session 的会话 id 值
         * 每个会话都有一个身份证号
         */
        String sessionId = session.getId();
        resp.getWriter().write(sessionId);

    }

    /**
     * setAttribute
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("setAttribute!");
        /**
         * session.setAttribute
         */
        req.getSession().setAttribute("key", "value");
        resp.getWriter().write("保存了数据成功");

    }

    /**
     * getAttribute
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAttribute!");
        /**
         * session.getAttribute
         */
        String value = (String) req.getSession().getAttribute("key");
        resp.getWriter().write("获取数据为" + value);

    }


    /**
     * session的生命周期
     *
     * API:
     * getMaxInactiveInterval
     * setMaxInactiveInterval
     * invalidate()
     *
     * XXX.xml配置:
     * <session-config>
     *     <session-timeout>30</session-timeout>
     * </session-config>
     */


    /**
     * 获取Session默认的超时时间
     * session.getMaxInactiveInterval
     * 默认的超时时间长为 30 分钟
     * 在 Tomcat 服务器的配置文件 web.xml中默认有以下的配置
     * <session-config>
     *     <session-timeout>30</session-timeout>
     * </session-config>
     * 设置web工程所有Session默认是20分钟超时时长
     * <session-config>
     *     <session-timeout>20</session-timeout>
     * </session-config>
     */
    protected void getTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        System.out.println(maxInactiveInterval);
    }

    /**
     * 设置Session超时时间
     * session.getMaxInactiveInterval
     */
    protected void setTime_3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setMaxInactiveInterval(3);
    }

    /**
     * 立即删除session
     * session.invalidate()
     */
    protected void setTime_0(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
    }


}
