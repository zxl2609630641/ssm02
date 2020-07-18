package com.ssm.daili.jdkd;

import com.ssm.entity.TabEmployee;

import java.util.List;

public interface EmpService {
    public List selectAll();

    public void updateEmp(TabEmployee employee);

    public void deleteEmp(TabEmployee employee);

    public void insertEmp(TabEmployee employee);
}
