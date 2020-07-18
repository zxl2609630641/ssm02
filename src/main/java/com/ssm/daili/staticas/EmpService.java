package com.ssm.daili.staticas;

import com.ssm.entity.ResultData;
import com.ssm.entity.TabEmployee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmpService {
    public List selectAll();

    public void updateEmp(TabEmployee employee);

    public void deleteEmp(TabEmployee employee);

    public void insertEmp(TabEmployee employee);
}
