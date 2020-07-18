package com.ssm.controller;

import com.ssm.entity.BusinessException;
import com.ssm.entity.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ceshi2")
public class ExceptionController2 {
    @RequestMapping("/test1")
    public String test1() {
        return "ceshi";
    }

    @RequestMapping("/test2")
    public String test2() {
        int i = 1 / 0;
        return "ceshi";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public ResultData test3() {
        String a = null;
        System.out.println(a.length());
        return new ResultData(true, "成功", null);
    }

    @RequestMapping("/test4")
    public String test4() throws BusinessException {
        try {
            String a = null;
            System.out.println(a.length());
        } catch (Exception e) {
            throw new BusinessException("测试错误");
        }
        return "ceshi";
    }
}
