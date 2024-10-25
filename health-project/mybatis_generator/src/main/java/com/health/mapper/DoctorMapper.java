package com.health.mapper;

import com.health.entities.Doctor;
import com.health.entities.DoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DoctorMapper extends Mapper<Doctor> {
    long countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    List<Doctor> selectByExampleWithBLOBs(DoctorExample example);

    List<Doctor> selectByExample(DoctorExample example);

    int updateByExampleSelective(@Param("row") Doctor row, @Param("example") DoctorExample example);

    int updateByExampleWithBLOBs(@Param("row") Doctor row, @Param("example") DoctorExample example);

    int updateByExample(@Param("row") Doctor row, @Param("example") DoctorExample example);
}