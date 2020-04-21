package com.liu.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: 52945
 * @Date: 2019/10/18 10:50
 * @Version: 1.0
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello world";
    }

    @GetMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        //Thymeleaf会在classpath:/templates/下找success.html
        return "success";
    }

}
