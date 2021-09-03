import javax.servlet.*;
import java.io.IOException;


/**
 * Filter过滤器  JavaWeb 的三大组件之一
 * 作用 拦截请求 过滤响应
 * 客户端------>Filter------>目标资源
 */

/**
 * Filter 的拦截路径   不用关心是否存在资源，只需要关系路径是否正确
 * --精确匹配
 * <url-pattern>/xxx.jsp</url-pattern>
 *   表示请求地址 http://ip:port/工程路径/xxx.jsp
 * --目录匹配
 * <url-pattern>/xxx/*</url-pattern>
 *   表示请求地址 http://ip:port/工程路径/xxx/*
 * --后缀名匹配
 * <url-pattern>*.xxx</url-pattern>  (可以自定义后缀)
 *   表示请求地址 以 .xxx结尾
 */



/**
 * web.xml
 *  <filter>
 *      <filter-name>Fiter_T</filter-name>
 *      <filter-class>filter.Filter_T</filter-class>
 *      <init-param>
 *          <param-name>username</param-name>
 *          <param-value>wyl</param-value>
 *      </init-param>
 *  </filter>
 *  <filter-mapping>
 *      <filter-name>Fiter_T</filter-name>
 *      <url-pattern>/</url-pattern>
 *  </filter-mapping>
 */
public class Filter_T implements Filter {

    
    /**
     * 生命周期
     * 1、构造器方法
     * 2、init 初始化方法    1 2在 web工程启动的时候执行（Filter 已经创建）
     * 3、doFilter过滤方法   3 每次拦截到请求，就会执行
     * 4、destroy销毁       4 停止 web工程的时候执行（停止 web 工程，也会销毁 Filter 过滤器）
     */
    public Filter_T() {
        System.out.println("1、构造器方法");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("2、init初始化方法");

        /**
         * FilterConfig
         *   获取 Filter 的名称 filter-name 的内容
         *   获取在 Filter 中配置的 init-param 初始化参数   //常用
         *   获取 ServletContext 对象
         */
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("username"));  //常用
        System.out.println(filterConfig.getServletContext());

    }

  
    /**
     * doFilter 方法   专门用于拦截请求  做权限检查
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3、doFilter过滤方法 ");

      
        /**
         * FilterChain 过滤器链  多个过滤器如何一起工作
         * 客户端------>filter1_chain前------>filter2_chain前------>目标资源------>filter2_chain后------>filter1_chain后------>响应给客户端  (chain没有则直接返回)
         * 顺序由xml的配置顺序决定
         * 同一个线程 同一个request对象
         */
        filterChain.doFilter(servletRequest, servletResponse);

    }


    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("4、destroy销毁");
    }


}
