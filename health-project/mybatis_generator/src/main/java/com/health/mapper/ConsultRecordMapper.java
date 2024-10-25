package com.health.mapper;

import com.health.entities.ConsultRecord;
import com.health.entities.ConsultRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ConsultRecordMapper extends Mapper<ConsultRecord> {
    long countByExample(ConsultRecordExample example);

    int deleteByExample(ConsultRecordExample example);

    List<ConsultRecord> selectByExampleWithBLOBs(ConsultRecordExample example);

    List<ConsultRecord> selectByExample(ConsultRecordExample example);

    int updateByExampleSelective(@Param("row") ConsultRecord row, @Param("example") ConsultRecordExample example);

    int updateByExampleWithBLOBs(@Param("row") ConsultRecord row, @Param("example") ConsultRecordExample example);

    int updateByExample(@Param("row") ConsultRecord row, @Param("example") ConsultRecordExample example);
}