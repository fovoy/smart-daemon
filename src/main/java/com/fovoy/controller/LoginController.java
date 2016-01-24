package com.fovoy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by james on 16/1/24.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "pages/login/login";
    }
}
