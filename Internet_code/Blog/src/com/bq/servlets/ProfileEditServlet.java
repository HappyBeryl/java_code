package com.bq.servlets;

import com.bq.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/*
用户资料修改
 */
@WebServlet("/profile/edit")
public class ProfileEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nickname = req.getParameter("nickname");
        String brief = req.getParameter("brief");
        // TODO: 合法性校验

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendError(401);
            return;
        }

        // HTTP 无状态特性，导致不知道修改的是哪个用户的资料
        // 通过登陆状态获取修改的哪个用户的资料
        try {
            User.update(user.id, nickname, brief);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        // 确保 Session 中的 用户信息也被修改
        user.nickname = nickname;
        user.brief = brief;
        session.setAttribute("user", user);

        resp.sendRedirect("/u");
    }
}
