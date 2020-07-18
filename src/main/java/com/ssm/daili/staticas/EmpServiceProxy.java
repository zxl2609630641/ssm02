package com.ssm.daili.staticas;

import com.ssm.entity.TabEmployee;

import java.util.List;

/**
 * 代理类：静态代理的代理类和目标类实现同一个接口
 * 共性代理的提取
 * 具体的业务：调用目标类进行操作
 */
public class EmpServiceProxy implements EmpService {
    //代理对象中操作的是目标对象
    EmpService empService = new EmpServiceImpl3();

    @Override
    public List selectAll() {
        return empService.selectAll();
    }

    @Override
    public void updateEmp(TabEmployee employee) {
        System.out.println("启动事务");
        System.out.println("打印日志");
        empService.updateEmp(employee);
        System.out.println("提交事务");
        System.out.println("打印结果返回");
    }

    @Override
    public void deleteEmp(TabEmployee employee) {
        System.out.println("启动事务");
        System.out.println("打印日志");
        empService.deleteEmp(employee);
        System.out.println("提交事务");
        System.out.println("打印结果返回");
    }

    @Override
    public void insertEmp(TabEmployee employee) {
        System.out.println("启动事务");
        System.out.println("打印日志");
        empService.insertEmp(employee);
        System.out.println("提交事务");
        System.out.println("打印结果返回");
    }
}
