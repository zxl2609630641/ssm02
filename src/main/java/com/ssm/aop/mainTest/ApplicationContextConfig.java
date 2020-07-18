package com.ssm.aop.mainTest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.ssm.aop")
@EnableAspectJAutoProxy
/*<!--开启注解扫描-->
<context:component-scan base-package="com.ssm.aop"/>
<!--启动AOP的自动的代理生成-->
<aop:aspectj-autoproxy/>*/
public class ApplicationContextConfig {
}
