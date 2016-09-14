package com.fovoy.daemon.controller;

import javax.annotation.Resource;

import com.fovoy.daemon.model.UserInfo;
import com.fovoy.daemon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(String userId){
		return "showUser";
	}
}
