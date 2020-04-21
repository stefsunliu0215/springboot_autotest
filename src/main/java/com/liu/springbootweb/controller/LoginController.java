package com.liu.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: 登录控制器
 * @Author: 52945
 * @Date: 2019/10/21 15:02
 * @Version: 1.0
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);  //将登录用户放到session中
            return "redirect:/main.html";
        } else {
            //登陆失败
            map.put("msg", "用户名或密码错误，登陆失败");
            return "login";
        }
    }

}
