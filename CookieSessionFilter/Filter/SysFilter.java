import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class sysFilter implements Filter {

    /**
     * web.xml配置
     *    <filter>
     *         <filter-name>sysFiter</filter-name>
     *         <filter-class>filter.sysFilter</filter-class>
     *    </filter>
     *    <filter-mapping>
     *         <filter-name>sysFiter</filter-name>
     *         <url-pattern>/filter/*</url-pattern>
     *    </filter-mapping>
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;  //
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
