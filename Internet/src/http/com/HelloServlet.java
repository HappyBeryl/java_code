package http.com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    //当GET请求处理的逻辑
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text.html: charset = utf-8");
        resp.getWriter().println("<h1>GET</h1>");
        resp.getWriter().println("<p>你好世界</p>");
    }

    //当 POST请求处理的逻辑
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text.html: charset = utf-8");
        resp.getWriter().println("<h1>GET</h1>");
        resp.getWriter().println("<p>你好世界</p>");

    }
}
