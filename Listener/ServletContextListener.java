
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * JavaWeb 的三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器
 * Listener 它是 JavaEE 的规范，就是接口
 * ServletContextListener 监听器
 * 可以监听 ServletContext 对象的创建和销毁 （ServletContext对象在web工程启动的时候创建，在web工程停止的时候销毁）
 * 监听到创建和销毁之后都会分别调用 ServletContextListener 监听器的方法反馈
 *
 * web.xml下配置
 * <listener>
 *     <listener-class>ServletContextListener</listener-class>
 * </listener>
 */

public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext 对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext 对象被销毁了");
    }
}
