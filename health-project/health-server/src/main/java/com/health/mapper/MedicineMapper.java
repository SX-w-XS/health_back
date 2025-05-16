package com.health.mapper;

import com.health.entities.Medicine;
import com.health.entities.MedicineExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface MedicineMapper extends Mapper<Medicine> {
    @Select("select * from medicine")
  List<Medicine> selectALLMedicine();
}