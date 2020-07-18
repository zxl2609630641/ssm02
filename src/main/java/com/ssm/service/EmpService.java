package com.ssm.service;

import com.ssm.entity.ResultData;
import com.ssm.entity.TabEmployee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmpService {
    public List<HashMap> selectAll();

    public List<HashMap> selectDept();

    public int insertEmp(Map map);

    public int updateEmp(Map map);

    public int deleteEmp(int id);

    public HashMap selectEmpById(int id);

    public ResultData insertEmp(TabEmployee employee) throws Exception;

    public ResultData insertEmpMore(List<TabEmployee> employee) throws Exception;

    public ResultData updateByPrimaryKeySelective(TabEmployee record) throws Exception;
}
