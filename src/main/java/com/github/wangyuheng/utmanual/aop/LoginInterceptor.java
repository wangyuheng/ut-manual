package com.github.wangyuheng.utmanual.aop;

import com.github.wangyuheng.utmanual.conf.UtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UtProperties utProperties;

    private static final String AUTHORIZATION = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (utProperties.isEnable()) {
            if (StringUtils.isEmpty(request.getHeader(AUTHORIZATION))) {
                return false;
            } else {
                return super.preHandle(request, response, handler);
            }
        }
        return super.preHandle(request, response, handler);
    }
}
