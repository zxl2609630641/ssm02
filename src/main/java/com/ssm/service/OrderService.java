package com.ssm.service;

import com.ssm.entity.ResultData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {
    List<HashMap> selectOrder();

    HashMap selectOrderdetail(int id);

    ResultData selectAccount(Map map);

    List<HashMap> selectVip(Map map);

    List<HashMap> selectPro();

    HashMap selectPro2(Map map);
}
