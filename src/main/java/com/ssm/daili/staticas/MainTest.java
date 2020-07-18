package com.ssm.daili.staticas;

import com.ssm.entity.TabEmployee;

public class MainTest {
    public static void main(String[] args) {
        //静态代理：好理解，很清晰能看到new的是代理对象
        EmpService empService = new EmpServiceProxy();
        empService.updateEmp(new TabEmployee());
    }
}
