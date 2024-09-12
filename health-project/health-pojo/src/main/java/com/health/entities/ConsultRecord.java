package com.health.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 表名：consult_record
*/
@Table(name = "consult_record")
public class ConsultRecord {
    /**
     * 咨询记录表ID
     */
    @Id
    @Column(name = "consultation_id")
    private Integer consultationId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 医生ID
     */
    @Column(name = "doctor_id")
    private Integer doctorId;

    /**
     * 日期
     */
    @Column(name = "consult_date")
    private Date consultDate;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 内容
     */
    private String content;

    /**
     * 获取咨询记录表ID
     *
     * @return consultationId - 咨询记录表ID
     */
    public Integer getConsultationId() {
        return consultationId;
    }

    /**
     * 设置咨询记录表ID
     *
     * @param consultationId 咨询记录表ID
     */
    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    /**
     * 获取用户ID
     *
     * @return userId - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
     * 获取日期
     *
     * @return consultDate - 日期
     */
    public Date getConsultDate() {
        return consultDate;
    }

    /**
     * 设置日期
     *
     * @param consultDate 日期
     */
    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}