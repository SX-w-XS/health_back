package com.health.mapper;

import com.health.entities.Doctor;
import com.health.entities.DoctorExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface DoctorMapper extends Mapper<Doctor> {

}