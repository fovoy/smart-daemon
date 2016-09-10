package com.fovoy.daemon.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zxz.zhang on 16/9/10.
 */
public class CookieUtil {


    public static String findCookieVal(HttpServletRequest request, String key) {
        Cookie cookie = findCookie(request, key);
        return cookie != null ? cookie.getValue() : null;
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
