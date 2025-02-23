package com.health.entities;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 表名：dm_record
 * 表注释：糖尿病记录
*/
@Table(name = "dm_record")
public class DmRecord {
    @Column(name = "user_id")
    private Integer userId;

    private String username;

    /**
     * 概率一
     */
    private Double probability0;

    /**
     * 概率二
     */
    private Double probability1;

    /**
     * 概率三
     */
    private Double probability2;

    /**
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取概率一
     *
     * @return probability0 - 概率一
     */
    public Double getProbability0() {
        return probability0;
    }

    /**
     * 设置概率一
     *
     * @param probability0 概率一
     */
    public void setProbability0(Double probability0) {
        this.probability0 = probability0;
    }

    /**
     * 获取概率二
     *
     * @return probability1 - 概率二
     */
    public Double getProbability1() {
        return probability1;
    }

    /**
     * 设置概率二
     *
     * @param probability1 概率二
     */
    public void setProbability1(Double probability1) {
        this.probability1 = probability1;
    }

    /**
     * 获取概率三
     *
     * @return probability2 - 概率三
     */
    public Double getProbability2() {
        return probability2;
    }

    /**
     * 设置概率三
     *
     * @param probability2 概率三
     */
    public void setProbability2(Double probability2) {
        this.probability2 = probability2;
    }
}