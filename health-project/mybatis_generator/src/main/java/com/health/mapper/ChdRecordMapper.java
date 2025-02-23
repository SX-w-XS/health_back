package com.health.mapper;

import com.health.entities.ChdRecord;
import com.health.entities.ChdRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ChdRecordMapper extends Mapper<ChdRecord> {
    long countByExample(ChdRecordExample example);

    int deleteByExample(ChdRecordExample example);

    List<ChdRecord> selectByExample(ChdRecordExample example);

    int updateByExampleSelective(@Param("row") ChdRecord row, @Param("example") ChdRecordExample example);

    int updateByExample(@Param("row") ChdRecord row, @Param("example") ChdRecordExample example);
}