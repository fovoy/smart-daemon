package com.fovoy.daemon.controller;


import com.fovoy.daemon.common.interceptor.UserInterceptor;
import com.fovoy.daemon.model.UserInfo;
import com.fovoy.daemon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by james on 16/1/24.
 */
@Controller
@RequestMapping(value = "/Login")
public class LoginController {
    //
//    @Resource
//    private UserService userService;
//
//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String index(){
//        return "pages/login/login";
//    }
//
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(@RequestParam("userName") String userName,
//                        @RequestParam("password") String password){
////        String userName = userFromPage.getUserName();
////        String password = userFromPage.getPassword();
//        System.out.println("User name is：" + userName);
//        System.out.println("Password is :" + password);
//        User userInDb = userService.getUserByUserName(userName);
//        System.out.println("从数据库中查到的记录的用户名为：" + userInDb.getUserName());
//        String passwordInDb = userInDb.getPassword();
//        if(password.equals(passwordInDb)){
//            return "pages/index/index";
//        }else {
//            return "pages/login/login";
//        }
//    }
    //这个@Resource的注释用于指明UserService在mybatis中的相关配置，如果不注释的话会返回null pointer exception
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login_submit", method = RequestMethod.GET)
    public ModelAndView login(String redirectURL) {
        ModelAndView view = new ModelAndView();
        //将拦截前的路径保存下来，用户登录成功后可以直接请求道登录前的页面
        view.addObject("redirectURL", redirectURL);
        view.setViewName("/index/login");
        return view;
    }

//    @RequestMapping(value = "/login_submit", method = RequestMethod.POST)
//    public String submit(@RequestParam("userName") String userName,
//                         @RequestParam("password") String password,
//                         String redirectURL, HttpServletRequest request) {
//        //获取用户名对应的密码
//        System.out.println("用户名" + userName);
//        UserInfo userInDb = userService.getUserByUserName(userName);
//        System.out.println("从数据库中查到的记录的用户名为：" + userInDb.getUserName());
//        //验证密码
//        //@TODO 密码要改成加密的md5形式的。
//        //密码正确
//        if(passwordInDb.equals(password)){
//            //用户登录成功，将用户消息存放到session中去
//            HttpSession session = request.getSession();
//            System.out.println(userName);
//            System.out.println(passwordInDb);
//            session.setAttribute(UserInterceptor.SEESION_MEMBER, userName);
//            if(!StringUtils.isEmpty(redirectURL)){
//                return "redirect:" + URLDecoder.decode(redirectURL);
//            }
//            return "redirect:/page/member/index.html";
//        }else{
//            //密码为空
//            if(!StringUtils.isEmpty(redirectURL)){
//                return "redirect:/index/login.jsp?" + URLDecoder.decode(redirectURL);
//            }
//            //密码不正确
//            return "redirect:/page/index/login.jsp";
//        }
//    }
}
