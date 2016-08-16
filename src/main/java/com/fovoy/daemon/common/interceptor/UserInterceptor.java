package com.fovoy.daemon.common.interceptor;

/**
 * Created by james on 2016/8/15.
 */

import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor {

    //这里不能用SESSION_MEMBER=null来初始化，否则在login里往里放值得时候，
    // 会得到一个错java.lang.IllegalArgumentException: seetAttribute name parameter cannot be null
    public final static String SEESION_MEMBER = "";

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                                Exception arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                           ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //请求的路径
        String contextPath=request.getContextPath();
        String  url=request.getServletPath().toString();
        System.out.println(url);
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute(SEESION_MEMBER);
        System.out.println(user);

        //这里可以根据session的用户来判断角色的权限，根据权限来重定向不同的页面，简单起见，这里只是做了一个重定向
        //如果提交过来的用户名和密码不为空，则跳转到LoginController中的方法进行处理
        if (user == null ||  user  == "" || user.equals("")) {
            //被拦截，重定向到login界面
            response.sendRedirect(contextPath+"/Login/?redirectURL="
                    + URLEncoder.encode(url));
            return false;
        }
        return true;
    }

}