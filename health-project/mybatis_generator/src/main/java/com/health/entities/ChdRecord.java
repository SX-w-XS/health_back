package com.health.entities;

import javax.persistence.*;

/**
 * 表名：chd_record
 * 表注释：冠心病记录表
*/
@Table(name = "chd_record")
public class ChdRecord {
    @Column(name = "user_id")
    private Integer userId;

    private String username;

    /**
     * 不患病率
     */
    private Double positive;

    /**
     * 患病率
     */
    private Double negative;

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
     * 获取不患病率
     *
     * @return positive - 不患病率
     */
    public Double getPositive() {
        return positive;
    }

    /**
     * 设置不患病率
     *
     * @param positive 不患病率
     */
    public void setPositive(Double positive) {
        this.positive = positive;
    }

    /**
     * 获取患病率
     *
     * @return negative - 患病率
     */
    public Double getNegative() {
        return negative;
    }

    /**
     * 设置患病率
     *
     * @param negative 患病率
     */
    public void setNegative(Double negative) {
        this.negative = negative;
    }
}