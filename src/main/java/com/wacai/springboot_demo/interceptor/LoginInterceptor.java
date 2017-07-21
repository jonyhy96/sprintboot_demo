package com.wacai.springboot_demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO 类描述
 *
 * @author pojun
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final String[] EXCLUDE_PREFIX = {"/user"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url =httpServletRequest.getServletPath();
        boolean exclude = false;
        for(String pre : EXCLUDE_PREFIX){
            if(url.startsWith(pre)){
                exclude = true;
                break;
            }
        }
        if(url.equals("/")){
            exclude = true;
        }
        if(!exclude){
            HttpSession session = httpServletRequest.getSession();
            if(session.getAttribute("userId") == null){
                httpServletResponse.sendRedirect("/user/login");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
