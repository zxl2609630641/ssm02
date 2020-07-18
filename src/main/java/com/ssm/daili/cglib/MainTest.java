package com.ssm.daili.cglib;

import com.ssm.entity.TabEmployee;

public class MainTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        //产生的子类
        EmpServiceImpl2 empService = (EmpServiceImpl2) cglibProxy.bind(new EmpServiceImpl2());
        empService.insertEmp(new TabEmployee());
    }
}
