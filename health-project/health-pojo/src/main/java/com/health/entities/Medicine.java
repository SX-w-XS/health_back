package com.health.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表名：medicine
 * 表注释：药物表
*/
@Table(name = "medicine")
public class Medicine {
    /**
     * 药物ID
     */
    @Id
    @Column(name = "medicine_id")
    private Integer medicineId;

    /**
     * 药物名
     */
    @Column(name = "medical_name")
    private String medicalName;

    /**
     * 药物图片
     */
    @Column(name = "medical_img")
    private String medicalImg;

    /**
     * 慎用人群
     */
    @Column(name = "cautionary_group")
    private String cautionaryGroup;

    /**
     * 疾病
     */
    @Column(name = "disease_id")
    private Integer diseaseId;

    /**
     * 适用症状
     */
    private String adaptations;

    /**
     * 用法
     */
    private String usage;

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
     * 获取药物名
     *
     * @return medicalName - 药物名
     */
    public String getMedicalName() {
        return medicalName;
    }

    /**
     * 设置药物名
     *
     * @param medicalName 药物名
     */
    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    /**
     * 获取药物图片
     *
     * @return medicalImg - 药物图片
     */
    public String getMedicalImg() {
        return medicalImg;
    }

    /**
     * 设置药物图片
     *
     * @param medicalImg 药物图片
     */
    public void setMedicalImg(String medicalImg) {
        this.medicalImg = medicalImg;
    }

    /**
     * 获取慎用人群
     *
     * @return cautionaryGroup - 慎用人群
     */
    public String getCautionaryGroup() {
        return cautionaryGroup;
    }

    /**
     * 设置慎用人群
     *
     * @param cautionaryGroup 慎用人群
     */
    public void setCautionaryGroup(String cautionaryGroup) {
        this.cautionaryGroup = cautionaryGroup;
    }

    /**
     * 获取疾病
     *
     * @return diseaseId - 疾病
     */
    public Integer getDiseaseId() {
        return diseaseId;
    }

    /**
     * 设置疾病
     *
     * @param diseaseId 疾病
     */
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * 获取适用症状
     *
     * @return adaptations - 适用症状
     */
    public String getAdaptations() {
        return adaptations;
    }

    /**
     * 设置适用症状
     *
     * @param adaptations 适用症状
     */
    public void setAdaptations(String adaptations) {
        this.adaptations = adaptations;
    }

    /**
     * 获取用法
     *
     * @return usage - 用法
     */
    public String getUsage() {
        return usage;
    }

    /**
     * 设置用法
     *
     * @param usage 用法
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }
}