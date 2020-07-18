package com.ssm.aop.mainTest;

import com.ssm.aop.service.EmpService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext
//                =new ClassPathXmlApplicationContext("config/applicationContext.xml");
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        //这个位置千万不能写实现类，默认是JDK代理实现——产生的不是EMpServiceImp的对象而是其的代理对象
        EmpService empService = (EmpService) context.getBean("empS");
        Integer returninfo = empService.insert(1);
        System.out.println(returninfo);
    }
}
