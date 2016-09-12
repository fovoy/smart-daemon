package com.fovoy.daemon.common.util;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zxz.zhang on 16/9/10.
 */
public class CookieUtil {


    public static String findCookieVal(HttpServletRequest request, String key) {
        Cookie cookie = findCookie(request, key);
        return cookie != null ? cookie.getValue() : null;
    }

    public static void setCookie(HttpServletResponse response, String key,String userName, String serverName) {
        Preconditions.checkNotNull(response, "response must not null");
        Preconditions.checkArgument(StringUtils.isNotBlank(userName), "userName must not null");
        if (response != null) {
            Cookie cookie = new Cookie(key, String.format("%s|%s", userName, String.valueOf(DateUtils.MILLIS_PER_DAY)));
            cookie.setDomain(serverName);
            cookie.setMaxAge(3 * 24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }


    private static Cookie findCookie(HttpServletRequest request, String key) {
        if (StringUtils.isNotBlank(key) && request != null) {
            Cookie[] cookies = request.getCookies();

            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if (key.equals(name)) {
                        return cookie;
                    }
                }
            }
        }
        return null;
    }
}
