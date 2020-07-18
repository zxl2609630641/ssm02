package com.ssm.controller;

import com.ssm.entity.ResultData;
import com.ssm.entity.TabEmployee;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/empAjax")
public class EmployeeController {
    @Autowired
    private EmpService empService;

    //SpringMVC已经做了异步的json的处理：ResponseBody：
    // 可以返回任何值：实体maplistlist<实体>...自动将其处理成out.print()
    //如果是对象会自动转换成json——依赖jar：jackson
    @RequestMapping("/selectAll")
    @ResponseBody
    public List selectAll() {
        List list = empService.selectAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("/insertEmpMore")
    //RequestBody:接收前台的json参数请求，所以前台可以封装非常复杂的json数据
    public ResultData insertEmpMore(@RequestBody List<TabEmployee> employeeList) throws Exception {
//return employeeService.insertEmp(employee);
        System.out.println(employeeList);
        return empService.insertEmpMore(employeeList);
    }

    @ResponseBody
    @RequestMapping("/selectEmpById")
    public HashMap selectEmpById(int employeeid) {
        return empService.selectEmpById(employeeid);
    }

    @ResponseBody
    @RequestMapping("/UpdateEmployee")
    public ResultData UpdateEmployee(TabEmployee tabEmployee) throws Exception {
        return empService.updateByPrimaryKeySelective(tabEmployee);
    }

    @ResponseBody
    @RequestMapping("/insertEmp")
    public ResultData insertEmp(TabEmployee tabEmployee) throws Exception {
        return empService.insertEmp(tabEmployee);
    }

}
