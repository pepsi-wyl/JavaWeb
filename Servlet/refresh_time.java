import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class refresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置刷新时间为1秒
        resp.setIntHeader("refresh", 1);
        //设置响应类型
        resp.setContentType("text/html;charset=UTF-8");

        Date date = new Date();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        String CT = ((hours < 10) ? ("0" + hours) : ("" + hours)) + ":" + ((minutes < 10) ? ("0" + minutes) : ("" + minutes) )+ ":" + ((seconds < 10) ? ("0" + seconds) : ("" + seconds));

        PrintWriter out = resp.getWriter();
        String title = "使用 Servlet 自动刷新页面";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是：" + CT + "</p>\n");
    }
}
