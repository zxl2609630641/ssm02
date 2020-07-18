package com.ssm.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
//切面类——里边书写具体的切面实现——通知
public class CommonAdvice {
    //前置通知：在方法执行之前进行执行，获取拦截的方法名  获取方法的参数等
    @Before("execution(* com.ssm.aop.service.*.*(..))")
    public void before(JoinPoint point) {
        System.out.println(point.getSignature().getName());
        System.out.println(point.getArgs());
        System.out.println("前置通知");
    }

    //最终通知：不管方法是否有异常都会执行
    @After("execution(* com.ssm.aop.service.*.*(..))")
    public void after(JoinPoint point) {
        System.out.println("最终通知");
    }

    //afterreturn是后置通知，必须方法正常执完毕才会执行
    @AfterReturning("execution(* com.ssm.aop.service.*.*(..))")
    public void afterReturn(JoinPoint point) {
        System.out.println("后置通知");
    }

    //异常通知：只要碰到异常方可执行；这个发生异常执行，Except e：接收异常信息
    @AfterThrowing(value = "execution(* com.ssm.aop.service.*.*(..))", throwing = "e")
    public void afterThrow(JoinPoint point, Exception e) {
        System.out.println("接收到异常信息：" + e.getMessage());
    }

    /*
        环绕通知将目标方法很包含起来：

            A . 所以必须在环绕通知中调用目标方法，如果不调用，目标方法不执行
            B . 必须将目标方法的返回值返回，否则调用的位置获取不到返回值
     */
    @Around("execution(* com.ssm.aop.service.*.*(..))")
    public Object arround(ProceedingJoinPoint point) {
        System.out.println("开启事务");
        System.out.println("环绕通知开始");
        Object obj = null;
        try {
            obj = point.proceed(point.getArgs());//调用目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("回滚事务");
        }
        System.out.println("环绕通知结束");
        System.out.println("提交事务");
        return obj;
    }
}
