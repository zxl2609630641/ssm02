package com.ssm.daili.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;//代理目标

    //产生代理对象的方法
    public Object bind(Object target) {
        this.target = target;
        //需要额外导入包——cglib——Spring包的中已经有了，所以不用在写了
        //可以帮助返回代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);//设置处理对象
        enhancer.setSuperclass(target.getClass());//设置父类——基于子类代理：代理类是目标的子类
        return enhancer.create();//产生一个代理对象
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object returnInfo = null;
        System.out.println("启动事务");
        System.out.println("打印日志" + objects);
        try {
            //考虑效率不用自己的method——而是调用代理调用父类的方法
            returnInfo = methodProxy.invokeSuper(target, objects);//目标执行的方法； target.方法名(args)
        } catch (Exception e) {
            System.out.println("事务回滚");
        }
        System.out.println("提交事务");
        System.out.println("打印结果返回" + returnInfo);
        return returnInfo;
    }
}
