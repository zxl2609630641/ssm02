package com.ssm.daili.staticas;

import com.ssm.entity.ResultData;
import com.ssm.entity.TabEmployee;
import com.ssm.mapper.TabEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl3 implements EmpService {
    @Override
    public List selectAll() {
        System.out.println("进行查询");
        return null;
    }

    @Override
    public void updateEmp(TabEmployee employee) {
        System.out.println("进行修改");
    }

    @Override
    public void deleteEmp(TabEmployee employee) {
        System.out.println("进行删除");
    }

    @Override
    public void insertEmp(TabEmployee employee) {
        System.out.println("进行新增");
    }
}
