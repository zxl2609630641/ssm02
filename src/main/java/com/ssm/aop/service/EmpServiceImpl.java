package com.ssm.aop.service;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AOP：代理
 * 切面  通知  切入点（多个连接点） 目标  代理（动态生成） 织入
 * A. 书写一个切面类，里边书写具体的通知
 * B. 配置一下切入点
 * C. 配置织入
 */
@Component("empS")
public class EmpServiceImpl implements EmpService {
    @Override
    public List select() {

        System.out.println("进行查询");
        return null;
    }

    @Override
    public Integer insert(int a) {
        System.out.println("进行新增");
        //int i=1/0;
        return 10;
    }

    @Override
    public void delete() {
        System.out.println("进行删除");
    }

    @Override
    public void update() {
        System.out.println("进行修改");
    }
}
