import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "up", value = "/up")
public class up extends HttpServlet {

    /**
     * 上传的路径
     */
    private String path = "G:\\idea\\javaweb\\down_up\\src\\main\\resources\\";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 解决乱码问题
         */
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        //判断上传的数据是否多段数据   multipart/form-data
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建解析器ServletFileUpload    创建工厂FileItemFactory
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try {
                //使用解析器解析request对象 得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                list.forEach((fileItem -> {
                    //boolean isFormField()   判断是否是普通表单字段 是true 否则false
                    if (fileItem.isFormField()) {
                        System.out.println(fileItem.getFieldName());  //name 属性值
                        try {  //解决中文乱码问题
                            System.out.println(new String(fileItem.getString().getBytes(StandardCharsets.ISO_8859_1),"UTF-8"));     //value 属性值
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(fileItem.getFieldName());  //name 属性值
                        System.out.println(fileItem.getName());       //文件名称
                        String uuid = UUID.randomUUID().toString();   //随机前缀
                        try {
                            fileItem.write(new File(path + uuid + fileItem.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("up失败!");
        }
    }
}
