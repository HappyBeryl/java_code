package com.bq.controller;

import model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "/index.html";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ResponseBody //解析为json格式
    public Object login2(@RequestParam("username") String username1, String password) {
        System.out.println(username1 + "=" + password);
        User user = new User();
        user.setUsername("bq");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login5", method = RequestMethod.POST)
    @ResponseBody //解析为json格式
    public Object login3(HttpServletRequest request, HttpServletResponse response,
                         @RequestBody User u) {
        if ("abc".equals(u.getUsername()) && "123".equals(u.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user",u);
        }
        User user = new User();
        user.setUsername("bq");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;

    }


}
