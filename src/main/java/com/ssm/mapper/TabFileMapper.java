package com.ssm.mapper;

import com.ssm.common.CommonMapper;
import com.ssm.entity.TabFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TabFileMapper extends CommonMapper<TabFile> {
}