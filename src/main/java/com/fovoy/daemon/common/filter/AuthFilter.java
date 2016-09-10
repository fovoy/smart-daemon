package com.fovoy.daemon.common.filter;

import com.fovoy.daemon.common.util.CookieUtil;
import com.fovoy.daemon.model.UserInfo;
import com.fovoy.daemon.service.UserService;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by zxz.zhang on 16/8/16.
 */
public class AuthFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    private Set<String> includeUrl = Sets.newHashSet();


    @Resource
    private UserService userService;

    /**
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String token = CookieUtil.findCookieVal(httpServletRequest, "f_u");
        //不需要验证的URL 直接通过,不验证,例如登录接口
        String URI = httpServletRequest.getRequestURI();
        if (token == null) {
            processAuth(httpServletRequest, httpServletResponse, chain);
        } else if (this.isExcludedUri(URI)) {
            chain.doFilter(request, response);
        }
        chain.doFilter(request, response);
    }

    private void processAuth(HttpServletRequest request, HttpServletResponse httpServletResponse, FilterChain chain) {

        try {
            if (request.getRequestURI().startsWith("login")) {
                long e = System.currentTimeMillis();
                String URI = request.getRequestURI();
                UserInfo userInfo = null;
                //用户验证
                String user = request.getParameter("user");
                String pwd = request.getParameter("password");
                String url = request.getParameter("url");
                userInfo = userService.AuthUser(user, pwd);
                if (userInfo != null) {
                    httpServletResponse.sendRedirect(url);
                }
            } else {
                httpServletResponse.sendRedirect("/login");
            }
        } catch (IOException e) {

        }
    }

    private boolean isExcludedUri(String requestURI) {
        if (CollectionUtils.isEmpty(getIncludeUrl())) {
            return false;
        }

        if (requestURI != null && getIncludeUrl().contains(requestURI)) {
            return true;
        }
        return false;
    }

    /**
     */
    @Override
    public void destroy() {
    }

    private Set<String> getIncludeUrl() {
        return includeUrl;
    }

    public void setIncludeUrl(Set<String> includeUrl) {
        this.includeUrl = includeUrl;
    }
}
