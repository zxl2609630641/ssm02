package com.ssm.inter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInter implements HandlerInterceptor {
    /**
     * 如果返回true那么请求继续，如果返回false说明不允许通过，也就意外这目标方法不会执行
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("LoginInter——preHandle");
        HttpSession session = httpServletRequest.getSession();
        Object obj = session.getAttribute("userinfo");
        if (obj != null) {
            return true;//已经登录就继续
        } else {
            //没有登录，异步响应信息为未登录——目前通篇异步所以需要用响应
            //如果是同步此处其实应该转发或者重定向到登录界面
            httpServletResponse.reset();//resd对象重置，否则容易报错
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.println(" {\"state\":false,\"message\":\"没有登录\"}");
            out.flush();
            out.close();
            return false;//请求终止
        }
    }

    /*执行目标方法之后，界面渲染之前——返回model之前执行代码*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInter——postHandle");
    }

    /**
     * 整体执行完毕之后
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("LoginInter——afterCompletion");

    }
}

