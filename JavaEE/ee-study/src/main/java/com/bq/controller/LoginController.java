package com.bq.controller;

import model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
