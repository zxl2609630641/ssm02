package com.ssm.service;

import com.ssm.entity.ResultData;
import com.ssm.entity.TabFile;

import java.util.List;

public interface FileService {
    List<TabFile> selectFile();

    ResultData insertFile(TabFile file);

    TabFile selectFileById(Integer id);
}
