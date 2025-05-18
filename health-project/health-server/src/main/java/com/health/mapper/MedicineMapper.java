package com.health.mapper;

import com.health.entities.Medicine;
import com.health.entities.MedicineExample;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface MedicineMapper extends Mapper<Medicine> {
    @Select("select * from medicine")
  List<Medicine> selectALLMedicine();

    @Insert("insert medicine (medical_name,medical_img,cautionary_group,disease_id,adaptations,useage)  values(#{medicalName},#{medicalImg},#{cautionaryGroup},#{diseaseId},#{adaptations},#{useage})")
    void insertMedicine(Medicine medicine);

    @Delete("delete from medicine where medicine_id = #{medicineId}")
    void deleteMedicine(Integer medicineId);

    @Update("update medicine set medical_img = #{path} where medical_name = #{medicalName}")
    void updateMedicine(String path,String medicalName);
}