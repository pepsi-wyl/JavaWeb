
/**
 *     <!--监听器-->
 *     <listener>
 *         <listener-class>HttpSessionListener</listener-class>
 *     </listener>
 */

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//在线人数监听
public class listener implements HttpSessionListener {

    //创建Session监听
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer outlineCount = (Integer) servletContext.getAttribute("outlineCount");
        if (outlineCount == null) {
            outlineCount = Integer.valueOf(1);
        } else {
            outlineCount = Integer.valueOf(outlineCount.intValue() + 1);
        }
        servletContext.setAttribute("outlineCount", outlineCount);
    }

    //销毁Session监听
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer outlineCount = (Integer) servletContext.getAttribute("outlineCount");
        if (outlineCount == null) {
            outlineCount = Integer.valueOf(0);
        } else {
            outlineCount = Integer.valueOf(outlineCount.intValue() - 1);
        }
        servletContext.setAttribute("outlineCount", outlineCount);
        HttpSession session = se.getSession();
        session.removeAttribute("outlineCount");
        session.invalidate();
    }
}
