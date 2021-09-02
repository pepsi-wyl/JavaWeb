import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;


@WebServlet(name = "down", value = "/down")
public class down extends HttpServlet {

    private String path = "G:\\idea\\javaweb\\down_up\\src\\main\\resources\\背景.jpg";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(getServletContext().getMimeType(path));        //设置下载文件类型
        String filename;
        if (request.getHeader("User-Agent").contains("Firefox"))
            filename = "=?utf-8?B?" + Base64.getEncoder().encodeToString(path.substring(path.lastIndexOf("\\") + 1).getBytes("utf-8")) + "?=";
        else
            filename = URLEncoder.encode(path.substring(path.lastIndexOf("\\") + 1), "UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);         //告诉客户端数据用于下载
        FileInputStream in = new FileInputStream(path);
        ServletOutputStream out = response.getOutputStream();
        IOUtils.copy(in, out);                         //用第三方jar包进行
        in.close();
        out.close();
//        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
//        ServletOutputStream out = response.getOutputStream();
//        int len;
//        byte[] bytes = new byte[1024];
//        while ((len = in.read(bytes)) != -1) {
//            out.write(bytes, 0, len);
//        }
//        out.close();
//        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
