package com.ssm.controller;

import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/selectEmp")
    public String selectEmp(Model model) {
        List list = empService.selectAll();
        model.addAttribute("list", list);
        return "empList";
    }

    @RequestMapping("/insertEmp")
    public String insertEmp(@RequestParam Map map) {
        empService.insertEmp(map);
        return "forward:selectEmp";
    }

    @RequestMapping("/deleteEmp")
    public String deleteEmp(Integer id) {
        empService.deleteEmp(id);
        return "forward:selectEmp";
    }

    @RequestMapping("/selectEmpById")
    public String selectEmpById(int id, Model model) {
        HashMap map = empService.selectEmpById(id);
        model.addAttribute("emp", map);
        return "/updateEmp";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestParam Map map) {
        empService.updateEmp(map);
        return "forward:selectEmp";
    }
}
