package com.ssm.controller;

import com.ssm.entity.BaseUtil;
import com.ssm.entity.ResultData;
import com.ssm.entity.TabEmployee;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController//此类只能书写异步
@RequestMapping("/restEmp")
public class EmpController2 {
    @Autowired
    private EmpService empService;

    @GetMapping("/Emp")
    //等价于@RequestMapping(method = RequestMethod.GET)
    public List selectEmp() {
        return empService.selectAll();
    }

    @GetMapping("/Dept")
    public List selectDept() {
        return empService.selectDept();
    }

    @GetMapping("/{id}")
    public HashMap selectById(@PathVariable Integer id) {
        return empService.selectEmpById(id);
    }

    @PostMapping
    public ResultData insertOrUpdateEmployee(TabEmployee employee) throws Exception {
        Object id = employee.getEmployeeid();
        if (BaseUtil.checkNotNull(id) == true) {
            return empService.updateByPrimaryKeySelective(employee);
        } else {
            return empService.insertEmp(employee);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable Integer id) {
        empService.deleteEmp(id);
    }
}
