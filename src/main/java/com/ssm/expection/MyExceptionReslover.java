package com.ssm.expection;

import com.ssm.entity.BusinessException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionReslover implements HandlerExceptionResolver {
    /**
     * 处理同步非常方便
     * 处理异步？？？？？？可以，非常麻烦，需要判断请求是不是异步，如果是异步如何进行响应等
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof BusinessException) {
            modelAndView.addObject("exception", e.getMessage());
            modelAndView.setViewName("error-busi");
        } else if (e instanceof NullPointerException) {
            modelAndView.addObject("exception", "空指针异常");
            modelAndView.setViewName("error-null");
        } else {
            modelAndView.addObject("exception", "未知异常");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}

