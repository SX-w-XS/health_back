package com.health.entities;

import javax.persistence.*;

/**
 * 表名：medical_use
 * 表注释：用药记录表
*/
@Table(name = "medical_use")
public class MedicalUse {
    /**
     * 记录表ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 病历ID
     */
    @Column(name = "record_id")
    private Integer recordId;

    /**
     * 药物ID
     */
    @Column(name = "medicine_id")
    private Integer medicineId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 使用频率
     */
    private String frequency;

    /**
     * 注意事项
     */
    private String precautions;

    /**
     * 获取记录表ID
     *
     * @return id - 记录表ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置记录表ID
     *
     * @param id 记录表ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * 获取药物ID
     *
     * @return medicineId - 药物ID
     */
    public Integer getMedicineId() {
        return medicineId;
    }

    /**
     * 设置药物ID
     *
     * @param medicineId 药物ID
     */
    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
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
     * 获取使用频率
     *
     * @return frequency - 使用频率
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * 设置使用频率
     *
     * @param frequency 使用频率
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * 获取注意事项
     *
     * @return precautions - 注意事项
     */
    public String getPrecautions() {
        return precautions;
    }

    /**
     * 设置注意事项
     *
     * @param precautions 注意事项
     */
    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }
}