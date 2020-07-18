package com.ssm.expection;

import com.ssm.entity.BusinessException;
import com.ssm.entity.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice //全文生效：全文的控制层都生效
public class MyExceptionReslover2 {
    // 异步
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultData business(Exception e) {
        return new ResultData(false, e.getMessage(), null);

    }

    // 异步
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultData nullPoint(Exception e) {
        return new ResultData(false, e.getMessage(), null);
    }

    //   同步
    @ExceptionHandler(Exception.class)
    public String to500() {
        return "error";
    }

}
