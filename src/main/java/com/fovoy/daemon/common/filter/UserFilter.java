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
public class UserFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UserFilter.class);
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
        if (this.isExcludedUri(URI)) {
            chain.doFilter(request, response);
        } else if (token == null) {
            processAuth(httpServletRequest, httpServletResponse, chain);
        } else {
            chain.doFilter(request, response);
        }
    }

    private void processAuth(HttpServletRequest request, HttpServletResponse httpServletResponse, FilterChain chain) {

        try {
            String URI = request.getRequestURI();
            if (URI.startsWith("/login")) {
                long e = System.currentTimeMillis();
                UserInfo userInfo = null;
                //用户验证
                String user = request.getParameter("user");
                String pwd = request.getParameter("password");
                String url = request.getParameter("url");
                userInfo = userService.AuthUser(user, pwd);
                if (userInfo != null) {
                    CookieUtil.setCookie(httpServletResponse, "f_u", userInfo.getUserName(), request.getServerName());
                    httpServletResponse.sendRedirect(url);
                }
            } else {
                httpServletResponse.sendRedirect("/page/login.html");
            }
        } catch (IOException e) {
            logger.error("processAuth error", e);
        }
    }

    private boolean isExcludedUri(String requestURI) {
        if (CollectionUtils.isEmpty(getIncludeUrl())) {
            return false;
        }

        if (requestURI != null && getIncludeUrl().contains(requestURI)) {
            return true;
        }
        for (String s : getIncludeUrl()) {
            if (s.endsWith("*")) {
                String url = s.substring(0, s.length() - 2);
                if (requestURI.startsWith(url)) {
                    return true;
                }
            }
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
