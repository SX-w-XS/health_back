package com.health.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * 表名：cure
 * 表注释：个性化治疗计划
*/
@Table(name = "cure")
public class Cure {
    /**
     * 计划表ID
     */
    @Id
    @Column(name = "cure_id")
    private Integer cureId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 创建日期
     */
    private Date date;

    /**
     * 疾病id
     */
    @Column(name = "disease_id")
    private Integer diseaseId;

    /**
     * 药物建议
     */
    @Column(name = "drug_advice")
    private String drugAdvice;

    /**
     * 饮食建议
     */
    @Column(name = "diet_advice")
    private String dietAdvice;

    /**
     * 运动建议
     */
    @Column(name = "exercise_advice")
    private String exerciseAdvice;

    /**
     * 获取计划表ID
     *
     * @return cureId - 计划表ID
     */
    public Integer getCureId() {
        return cureId;
    }

    /**
     * 设置计划表ID
     *
     * @param cureId 计划表ID
     */
    public void setCureId(Integer cureId) {
        this.cureId = cureId;
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
     * 获取创建日期
     *
     * @return date - 创建日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置创建日期
     *
     * @param date 创建日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取疾病id
     *
     * @return diseaseId - 疾病id
     */
    public Integer getDiseaseId() {
        return diseaseId;
    }

    /**
     * 设置疾病id
     *
     * @param diseaseId 疾病id
     */
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * 获取药物建议
     *
     * @return drugAdvice - 药物建议
     */
    public String getDrugAdvice() {
        return drugAdvice;
    }

    /**
     * 设置药物建议
     *
     * @param drugAdvice 药物建议
     */
    public void setDrugAdvice(String drugAdvice) {
        this.drugAdvice = drugAdvice;
    }

    /**
     * 获取饮食建议
     *
     * @return dietAdvice - 饮食建议
     */
    public String getDietAdvice() {
        return dietAdvice;
    }

    /**
     * 设置饮食建议
     *
     * @param dietAdvice 饮食建议
     */
    public void setDietAdvice(String dietAdvice) {
        this.dietAdvice = dietAdvice;
    }

    /**
     * 获取运动建议
     *
     * @return exerciseAdvice - 运动建议
     */
    public String getExerciseAdvice() {
        return exerciseAdvice;
    }

    /**
     * 设置运动建议
     *
     * @param exerciseAdvice 运动建议
     */
    public void setExerciseAdvice(String exerciseAdvice) {
        this.exerciseAdvice = exerciseAdvice;
    }
}