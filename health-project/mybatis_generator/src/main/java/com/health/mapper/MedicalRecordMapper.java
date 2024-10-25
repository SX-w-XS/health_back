package com.health.mapper;

import com.health.entities.MedicalRecord;
import com.health.entities.MedicalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MedicalRecordMapper extends Mapper<MedicalRecord> {
    long countByExample(MedicalRecordExample example);

    int deleteByExample(MedicalRecordExample example);

    List<MedicalRecord> selectByExampleWithBLOBs(MedicalRecordExample example);

    List<MedicalRecord> selectByExample(MedicalRecordExample example);

    int updateByExampleSelective(@Param("row") MedicalRecord row, @Param("example") MedicalRecordExample example);

    int updateByExampleWithBLOBs(@Param("row") MedicalRecord row, @Param("example") MedicalRecordExample example);

    int updateByExample(@Param("row") MedicalRecord row, @Param("example") MedicalRecordExample example);
}