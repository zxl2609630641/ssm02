package com.ssm.daili.jdkd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用来书写动态代理对象的生成代码
 * Proxy.newProxyInstance
 */
public class JDKProxy implements InvocationHandler {
    //目标作为成员变量——可以根据不同的目标生成不同的代理对象
    private Object target;//代理目标——最终要根据代理目标来生成代理类

    //根据传入的目标对象生成动态的代理对象
    public Object bind(Object target) {
        this.target = target;//每一次传入的目标不同，生成的代理对象就不同
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 代理中的统一处理：代理类做的事情；调用目标类
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnInfo = null;
        System.out.println("启动事务");
        System.out.println("打印日志" + args);
        try {
            returnInfo = method.invoke(target, args);//目标执行的方法； target.方法名(args)
        } catch (Exception e) {
            System.out.println("事务回滚");
        }
        System.out.println("提交事务");
        System.out.println("打印结果返回" + returnInfo);
        return returnInfo;
    }
}
