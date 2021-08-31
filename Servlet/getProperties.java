

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class properties extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
//      FileInputStream is = new FileInputStream("G:\\idea\\maven\\target\\maven\\WEB-INF\\classes\\db.properties");
        Properties properties = new Properties();
        properties.load(is);
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        resp.getWriter().println(driver + user + password);
    }
}
