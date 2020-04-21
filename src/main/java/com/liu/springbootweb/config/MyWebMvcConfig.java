package com.liu.springbootweb.config;

import com.liu.springbootweb.component.LoginHandlerInterceptor;
import com.liu.springbootweb.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyWebMvcConfig
 * @Description: 自定义mvc配置类，扩展SpringMvc的功能
 * @Author: 52945
 * @Date: 2019/10/20 20:31
 * @Version: 1.0
 */
//@EnableWebMvc
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //发送请求/hi，跳转到success.html页面
//        registry.addViewController("/hi").setViewName("success");
        //定义首页的跳转，一般的空方法，都会在这里定义跳转
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        //防止表单重复提交，重定向到主页
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //将自定义的区域解析器添加到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //将自定义的登录拦截器添加到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                //放行跳转登录页面以及登录请求
                //SpringBoot2.x版本的需要注意：需要手动放行静态资源文件的请求，以及webjars下面的请求
                .excludePathPatterns("/index.html", "/", "/login", "/asserts/**", "/webjars/**");
    }

}