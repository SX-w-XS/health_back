package com.health.entities;

import javax.persistence.*;

/**
 * 表名：suggestion
 * 表注释：建议表
*/
@Table(name = "suggestion")
public class Suggestion {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 建议
     */
    private String suggest;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分数
     *
     * @return score - 分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置分数
     *
     * @param score 分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取建议
     *
     * @return suggest - 建议
     */
    public String getSuggest() {
        return suggest;
    }

    /**
     * 设置建议
     *
     * @param suggest 建议
     */
    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }
}