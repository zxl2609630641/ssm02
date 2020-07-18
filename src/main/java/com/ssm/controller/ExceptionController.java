package com.ssm.controller;

import com.ssm.entity.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ceshi")
public class ExceptionController {
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
    public String test3() {
        String a = null;
        System.out.println(a.length());
        return "ceshi";
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

