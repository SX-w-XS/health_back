package com.health.mapper;

import com.health.entities.MedicalUse;
import com.health.entities.MedicalUseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MedicalUseMapper extends Mapper<MedicalUse> {
    long countByExample(MedicalUseExample example);

    int deleteByExample(MedicalUseExample example);

    List<MedicalUse> selectByExampleWithBLOBs(MedicalUseExample example);

    List<MedicalUse> selectByExample(MedicalUseExample example);

    int updateByExampleSelective(@Param("row") MedicalUse row, @Param("example") MedicalUseExample example);

    int updateByExampleWithBLOBs(@Param("row") MedicalUse row, @Param("example") MedicalUseExample example);

    int updateByExample(@Param("row") MedicalUse row, @Param("example") MedicalUseExample example);
}