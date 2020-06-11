package com.bq.controller;


import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/1")
public class LoginController {

    /**
     * 两个页面，login.html和index.html，哪些url能够访问，每个url访问的时候，是否是转发的
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Integer i){
        if(i == 1)
            return "redirect:/index.html";  //重定向
        else
            return "forward:/index.html"; //转发
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam("username") String username1,
                         String password,
                         String password2){
        System.out.println(username1+"="+password+", "+password2);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login3", method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    //settings-keymap-eclipse: ctrl+alt+向下方向键
    @RequestMapping(value = "/login4", method = RequestMethod.POST)
    @ResponseBody
    public Object login4(@RequestBody User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login5", method = RequestMethod.POST)
    @ResponseBody
    public Object login5(HttpServletRequest request, HttpServletResponse response,
                         User u){
        if("abc".equals(u.getUsername()) && "123".equals(u.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            User user = new User();
            user.setUsername("烤鸭");
            user.setPassword("123");
            user.setBirthday(new Date());
            return user;
        }
        throw new RuntimeException("登录不成功");
    }

}
