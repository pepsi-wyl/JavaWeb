package Servlet;

import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("zhazha".equals(username) && "888888".equals(password)) {
            req.setAttribute("massage", "登陆成功");
            System.out.println("登录 成功");
            CookieUtils.creatCookie("username", username, 60 * 60, resp);
        } else {
            req.setAttribute("massage", "登陆失败");
            System.out.println("登录 失败");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
