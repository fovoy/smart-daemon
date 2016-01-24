package com.fovoy.controller;


import com.fovoy.pojo.User;
import com.fovoy.service.IUserService;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by james on 16/1/24.
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@Controller
public class LoginController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "pages/login/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password){
//        String userName = userFromPage.getUserName();
//        String password = userFromPage.getPassword();
        System.out.println("User name is：" + userName);
        System.out.println("Password is :" + password);
        User userInDb = userService.getUserByUserName(userName);
        String passwordInDb = userInDb.getPassword();
        if(password.equals(passwordInDb)){
            return "pages/index/index";
        }else {
            return "pages/login/login";
        }
    }

}
