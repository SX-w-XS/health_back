package com.health.mapper;

import com.health.entities.Medicine;
import com.health.entities.MedicineExample;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MedicineMapper extends Mapper<Medicine> {
    // 查询所有药品信息
    @Select("select * from medicine")
    List<Medicine> selectALLMedicine();

    // 插入一条药品记录
    @Insert("insert medicine (medical_name,medical_img,cautionary_group,disease_id,adaptations,useage) " +
            "values(#{medicalName},#{medicalImg},#{cautionaryGroup},#{diseaseId},#{adaptations},#{useage})")
    void insertMedicine(Medicine medicine);

    // 根据药品ID删除一条药品记录
    @Delete("delete from medicine where medicine_id = #{medicineId}")
    void deleteMedicine(Integer medicineId);

    // 更新药品图片路径
    @Update("update medicine set medical_img = #{path} where medical_name = #{medicalName}")
    void updateMedicine(String path, String medicalName);
}
