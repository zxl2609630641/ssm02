package com.ssm.controller;

import com.ssm.entity.ResultData;
import com.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List selectOrder() {
        return orderService.selectOrder();
    }

    @GetMapping("/{id}")
    public HashMap selectById(@PathVariable Integer id) {
        return orderService.selectOrderdetail(id);
    }

    @PostMapping("/login")
    public ResultData selectAccount(@RequestParam Map map, HttpSession session) {
        ResultData data = orderService.selectAccount(map);
        System.out.println(data);
        if (data.isState()) {
            session.setAttribute("userinfo", data.getMessage());
        }
        return data;
    }

    @GetMapping("/vip")
    public List<HashMap> selectVip(@RequestParam Map map) {
        return orderService.selectVip(map);
    }

    @GetMapping("/product")
    public List<HashMap> selectPro() {
        return orderService.selectPro();
    }

    @GetMapping("/pro")
    public HashMap selectPro2(@RequestParam Map map) {
        return orderService.selectPro2(map);
    }
}
