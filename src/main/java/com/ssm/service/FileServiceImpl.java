package com.ssm.service;

import com.ssm.entity.ResultData;
import com.ssm.entity.TabFile;
import com.ssm.mapper.TabFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private TabFileMapper mapper;

    @Override
    public List<TabFile> selectFile() {
        return mapper.selectAll();
    }

    @Override
    public ResultData insertFile(TabFile file) {
        try {
            mapper.insertSelective(file);
            return new ResultData(true, "新增成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TabFile selectFileById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
