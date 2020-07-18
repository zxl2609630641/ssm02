package com.ssm.daili.jdkd;

import com.ssm.entity.TabEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class EmpServiceImpl implements EmpService {
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
