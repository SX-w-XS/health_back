package com.health.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * 表名：medical_record
 * 表注释：病历表
*/
@Table(name = "medical_record")
public class MedicalRecord {
    /**
     * 病历ID
     */
    @Id
    @Column(name = "record_id")
    private Integer recordId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 诊断医生
     */
    @Column(name = "doctor_id")
    private Integer doctorId;

    /**
     * 诊断日期
     */
    @Column(name = "diagnostic_time")
    private Date diagnosticTime;

    /**
     * 现病史
     */
    private String content;

    /**
     * 既往史
     */
    @Column(name = "past_medical_history")
    private String pastMedicalHistory;

    /**
     * 个人史
     */
    @Column(name = "personal_history")
    private String personalHistory;

    /**
     * 用药史
     */
    @Column(name = "medication_history")
    private String medicationHistory;

    /**
     * 诊断结果
     */
    private String diagnostic;

    /**
     * 治疗方案
     */
    private String treatment;

    /**
     * 检查结果
     */
    @Column(name = "check_result")
    private String checkResult;

    /**
     * 获取病历ID
     *
     * @return recordId - 病历ID
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * 设置病历ID
     *
     * @param recordId 病历ID
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
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
     * 获取诊断医生
     *
     * @return doctorId - 诊断医生
     */
    public Integer getDoctorId() {
        return doctorId;
    }

    /**
     * 设置诊断医生
     *
     * @param doctorId 诊断医生
     */
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * 获取诊断日期
     *
     * @return diagnosticTime - 诊断日期
     */
    public Date getDiagnosticTime() {
        return diagnosticTime;
    }

    /**
     * 设置诊断日期
     *
     * @param diagnosticTime 诊断日期
     */
    public void setDiagnosticTime(Date diagnosticTime) {
        this.diagnosticTime = diagnosticTime;
    }

    /**
     * 获取现病史
     *
     * @return content - 现病史
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置现病史
     *
     * @param content 现病史
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取既往史
     *
     * @return pastMedicalHistory - 既往史
     */
    public String getPastMedicalHistory() {
        return pastMedicalHistory;
    }

    /**
     * 设置既往史
     *
     * @param pastMedicalHistory 既往史
     */
    public void setPastMedicalHistory(String pastMedicalHistory) {
        this.pastMedicalHistory = pastMedicalHistory;
    }

    /**
     * 获取个人史
     *
     * @return personalHistory - 个人史
     */
    public String getPersonalHistory() {
        return personalHistory;
    }

    /**
     * 设置个人史
     *
     * @param personalHistory 个人史
     */
    public void setPersonalHistory(String personalHistory) {
        this.personalHistory = personalHistory;
    }

    /**
     * 获取用药史
     *
     * @return medicationHistory - 用药史
     */
    public String getMedicationHistory() {
        return medicationHistory;
    }

    /**
     * 设置用药史
     *
     * @param medicationHistory 用药史
     */
    public void setMedicationHistory(String medicationHistory) {
        this.medicationHistory = medicationHistory;
    }

    /**
     * 获取诊断结果
     *
     * @return diagnostic - 诊断结果
     */
    public String getDiagnostic() {
        return diagnostic;
    }

    /**
     * 设置诊断结果
     *
     * @param diagnostic 诊断结果
     */
    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    /**
     * 获取治疗方案
     *
     * @return treatment - 治疗方案
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     * 设置治疗方案
     *
     * @param treatment 治疗方案
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    /**
     * 获取检查结果
     *
     * @return checkResult - 检查结果
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置检查结果
     *
     * @param checkResult 检查结果
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
}