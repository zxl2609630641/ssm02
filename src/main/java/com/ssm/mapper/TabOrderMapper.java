package com.ssm.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TabOrderMapper {
    List<HashMap> selectOrder();

    HashMap selectOrderdetail(int id);

    List<HashMap> selectAccount(Map map);

    List<HashMap> selectVip(Map map);

    List<HashMap> selectPro();

    HashMap selectPro2(Map map);
}