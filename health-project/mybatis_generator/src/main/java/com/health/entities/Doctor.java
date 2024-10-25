package com.health.entities;

import javax.persistence.*;

/**
 * 表名：doctor
 * 表注释：医生表
*/
@Table(name = "doctor")
public class Doctor {
    /**
     * 医生ID
     */
    @Id
    @Column(name = "doctor_id")
    private Integer doctorId;

    /**
     * 医生姓名
     */
    @Column(name = "doctor_name")
    private String doctorName;

    /**
     * 医生性别
     */
    @Column(name = "doctor_sex")
    private Integer doctorSex;

    /**
     * 医生年龄
     */
    @Column(name = "doctor_age")
    private Integer doctorAge;

    /**
     * 职务
     */
    private String office;

    /**
     * 所属医院
     */
    private String hospital;

    /**
     * 擅长方向
     */
    private String direction;

    /**
     * 获取医生ID
     *
     * @return doctorId - 医生ID
     */
    public Integer getDoctorId() {
        return doctorId;
    }

    /**
     * 设置医生ID
     *
     * @param doctorId 医生ID
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * 获取医生姓名
     *
     * @return doctorName - 医生姓名
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * 设置医生姓名
     *
     * @param doctorName 医生姓名
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * 获取医生性别
     *
     * @return doctorSex - 医生性别
     */
    public Integer getDoctorSex() {
        return doctorSex;
    }

    /**
     * 设置医生性别
     *
     * @param doctorSex 医生性别
     */
    public void setDoctorSex(Integer doctorSex) {
        this.doctorSex = doctorSex;
    }

    /**
     * 获取医生年龄
     *
     * @return doctorAge - 医生年龄
     */
    public Integer getDoctorAge() {
        return doctorAge;
    }

    /**
     * 设置医生年龄
     *
     * @param doctorAge 医生年龄
     */
    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }

    /**
     * 获取职务
     *
     * @return office - 职务
     */
    public String getOffice() {
        return office;
    }

    /**
     * 设置职务
     *
     * @param office 职务
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * 获取所属医院
     *
     * @return hospital - 所属医院
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * 设置所属医院
     *
     * @param hospital 所属医院
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    /**
     * 获取擅长方向
     *
     * @return direction - 擅长方向
     */
    public String getDirection() {
        return direction;
    }

    /**
     * 设置擅长方向
     *
     * @param direction 擅长方向
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
}