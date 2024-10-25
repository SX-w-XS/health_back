package com.health.mapper;

import com.health.entities.Medicine;
import com.health.entities.MedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MedicineMapper extends Mapper<Medicine> {
    long countByExample(MedicineExample example);

    int deleteByExample(MedicineExample example);

    List<Medicine> selectByExampleWithBLOBs(MedicineExample example);

    List<Medicine> selectByExample(MedicineExample example);

    int updateByExampleSelective(@Param("row") Medicine row, @Param("example") MedicineExample example);

    int updateByExampleWithBLOBs(@Param("row") Medicine row, @Param("example") MedicineExample example);

    int updateByExample(@Param("row") Medicine row, @Param("example") MedicineExample example);
}