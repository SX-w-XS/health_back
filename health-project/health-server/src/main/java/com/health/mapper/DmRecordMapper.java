package com.health.mapper;

import com.health.entities.DmRecord;
import com.health.entities.DmRecordExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DmRecordMapper extends Mapper<DmRecord> {
    long countByExample(DmRecordExample example);

    int deleteByExample(DmRecordExample example);

    List<DmRecord> selectByExample(DmRecordExample example);

    int updateByExampleSelective(@Param("row") DmRecord row, @Param("example") DmRecordExample example);

    int updateByExample(@Param("row") DmRecord row, @Param("example") DmRecordExample example);
}