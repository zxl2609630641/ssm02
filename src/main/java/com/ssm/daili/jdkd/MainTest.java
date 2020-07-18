package com.ssm.daili.jdkd;

import com.ssm.entity.TabEmployee;

public class MainTest {
    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        //代理对象需要自动生成_传入目标返回一个动态代理类
        EmpService empService = (EmpService) jdkProxy.bind(new EmpServiceImpl());
        empService.insertEmp(new TabEmployee());
    }
}
