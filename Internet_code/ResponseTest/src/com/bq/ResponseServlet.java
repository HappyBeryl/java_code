package com.bq;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response-demo")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  HTTP 响应状态的 API
        resp.setStatus(400);
        resp.sendError(404, "hh");   // setStatus + 填充正文
        resp.sendRedirect("/");

        // 设置 HTTP 响应头
        resp.setHeader("Key", "Value");
        resp.setHeader("Content-Type", "halou");
        // key  value
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setContentType("text/html; charset=utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.setIntHeader("Key", 18);
        resp.setHeader("Key", String.valueOf(18));

        // 填充正文内容
        // 文本 —— 主要方式
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("中国真美丽");
        writer.println("大家一定强");

        // 不是文本内容 —— 图片文件

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        ServletOutputStream outputStream = resp.getOutputStream();

    }
}
