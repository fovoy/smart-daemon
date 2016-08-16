package com.fovoy.daemon.common.filter;

import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        //不需要验证的URL 直接通过,不验证,例如登录接口
        if (inLoginUri(httpServletRequest)) {
            chain.doFilter(request, response);
        } else {

            try {
                //用户验证

            } finally {

            }
        }
    }

    private boolean inLoginUri(HttpServletRequest request) {
        if (CollectionUtils.isEmpty(getIncludeUrl())) {
            return false;
        }

        String requestURI = request.getRequestURI();
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
