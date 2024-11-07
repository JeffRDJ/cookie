package cc.openhome;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        if ("tom".equals(user) && "123456".equals(passwd)) {
            String login = request.getParameter("login");
            /*
             * 实作步骤1、2
             * */
            if ("auto".equals(login)) {
                Cookie cookie = new Cookie("user", "tom");
                cookie.setMaxAge(7 * 24 * 60 * 60); //设置cookie一星期有效
                response.addCookie(cookie);
            }
            request.setAttribute("user", user);
            request.getRequestDispatcher("user.view").forward(request, response);

        } else {
            response.sendRedirect("login.html");
        }
    }
} 
