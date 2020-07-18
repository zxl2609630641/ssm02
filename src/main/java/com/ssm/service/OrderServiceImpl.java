package com.ssm.service;

import com.ssm.entity.ResultData;
import com.ssm.mapper.TabOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TabOrderMapper mapper;

    @Override
    public List<HashMap> selectOrder() {
        return mapper.selectOrder();
    }

    @Override
    public HashMap selectOrderdetail(int id) {
        return mapper.selectOrderdetail(id);
    }

    @Override
    public ResultData selectAccount(Map map) {
        List list = mapper.selectAccount(map);
        if (list != null && list.size() > 0) {
            return new ResultData(true, "登陆成功", null);
        }
        return new ResultData(false, "没有登录", null);
    }

    @Override
    public List<HashMap> selectVip(Map map) {
        return mapper.selectVip(map);
    }

    @Override
    public List<HashMap> selectPro() {
        return mapper.selectPro();
    }

    @Override
    public HashMap selectPro2(Map map) {
        return mapper.selectPro2(map);
    }
}
