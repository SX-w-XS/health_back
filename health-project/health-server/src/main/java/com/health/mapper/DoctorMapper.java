package com.health.mapper;

import com.health.entities.Doctor;
import com.health.entities.DoctorExample;
import com.health.vo.DoctorVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface DoctorMapper extends Mapper<Doctor> {
//插入医生信息
    @Insert("insert into doctor (doctor_id, doctor_name, doctor_sex, doctor_age, office, hospital, direction) values (#{doctorId},#{doctorName},#{doctorSex},#{doctorAge},#{office},#{hospital},#{direction})")
    void insertDoctor(Doctor doctor);
//修改医生信息
    @Update("update doctor set office = #{office}, hospital = #{hospital}, direction = #{direction} where doctor_id = #{doctorId}")
    void updateDoctor(Doctor doctor);
//获取所有医生信息
    @Select("select d.*,user_img as img from doctor d join h_user u on d.doctor_id = u.user_id")
    List<DoctorVO> getAllDoctors();
//获取医生自身信息
    @Select("select * from doctor where doctor_id = #{doctorId}")
    Doctor getDoctorById(Integer doctorId);
}