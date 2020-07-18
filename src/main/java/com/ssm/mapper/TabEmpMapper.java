package com.ssm.mapper;

import com.ssm.entity.TabEmployee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository//持久层Bean
public interface TabEmpMapper {
    public List<HashMap> selectAll();

    public List<HashMap> selectDept();

    public int insertEmp(Map map);

    public int updateEmp(Map map);

    public int deleteEmp(int id);

    public HashMap selectEmpById(int id);

    int insertSelective(TabEmployee record);

    int updateByPrimaryKeySelective(TabEmployee record);
}
