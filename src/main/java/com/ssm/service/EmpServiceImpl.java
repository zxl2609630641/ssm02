package com.ssm.service;

import com.ssm.entity.ResultData;
import com.ssm.entity.TabEmployee;
import com.ssm.mapper.TabEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private TabEmpMapper tabEmpMapper;

    @Override
    public List<HashMap> selectAll() {
        return tabEmpMapper.selectAll();
    }

    @Override
    public List<HashMap> selectDept() {
        return tabEmpMapper.selectDept();
    }

    @Override
    public int insertEmp(Map map) {
        return tabEmpMapper.insertEmp(map);
    }

    @Override
    public int updateEmp(Map map) {
        return tabEmpMapper.updateEmp(map);
    }

    @Override
    public int deleteEmp(int id) {
        return tabEmpMapper.deleteEmp(id);
    }

    @Override
    public HashMap selectEmpById(int id) {
        return tabEmpMapper.selectEmpById(id);
    }

    //配置这个方法以事务形式启动
    //propagation:传播特性 rollback：发生什么异常时回滚
    //service千万别trycatch之后，不throw，如果直接service处理了，AOP是接收不到异常，
    // 就不会回滚——基于AOP的环绕通知
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultData insertEmp(TabEmployee employee) throws Exception {
        ResultData resultData;
        try {
            int i = tabEmpMapper.insertSelective(employee);
            //int b=1/0;
            //tabEmpMapper.insertSelective(employee);
            if (i > 0) {
                resultData = new ResultData(true, "新增成功", null);
            } else {
                resultData = new ResultData(false, "新增失败", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultData;
    }

    @Override
    public ResultData insertEmpMore(List<TabEmployee> employee) throws Exception {
        ResultData resultData;
        try {
            for (int i = 0; i < employee.size(); i++) {
                tabEmpMapper.insertSelective(employee.get(i));
            }
            resultData = new ResultData(true, "新增成功", null);

        } catch (Exception e) {
            resultData = new ResultData(false, "新增失败", null);
            throw e;
        }
        return resultData;
    }

    @Override
    public ResultData updateByPrimaryKeySelective(TabEmployee record) throws Exception {
        ResultData resultData;
        try {
            int i = tabEmpMapper.updateByPrimaryKeySelective(record);
            if (i > 0) {
                resultData = new ResultData(true, "修改成功", null);
            } else {
                resultData = new ResultData(false, "修改失败", null);
            }
        } catch (Exception e) {
            throw e;
        }
        return resultData;
    }


}
