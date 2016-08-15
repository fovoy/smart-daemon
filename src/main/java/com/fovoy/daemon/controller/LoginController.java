package com.fovoy.daemon.controller;


import com.fovoy.daemon.model.User;
import com.fovoy.daemon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by james on 16/1/24.
 */
@Controller
@RequestMapping(value = "/Login")
public class LoginController {

    @Resource
    private UserService userService;

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
        System.out.println("从数据库中查到的记录的用户名为：" + userInDb.getUserName());
        String passwordInDb = userInDb.getPassword();
        if(password.equals(passwordInDb)){
            return "pages/index/index";
        }else {
            return "pages/login/login";
        }
    }

}
