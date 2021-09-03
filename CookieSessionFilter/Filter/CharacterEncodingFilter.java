import javax.servlet.*;
import java.io.IOException;


/**
 * 解决乱码过滤器
 */
public class CharacterEncodingFilter implements Filter {

    /**
     * web.xml配置
     *     <filter>
     *         <filter-name>CharacterEncodingFilter</filter-name>
     *         <filter-class>filter.CharacterEncodingFilter</filter-class>
     *     </filter>
     *     <filter-mapping>
     *         <filter-name>CharacterEncodingFilter</filter-name>
     *         <url-pattern>/</url-pattern>
     *     </filter-mapping>
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
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
