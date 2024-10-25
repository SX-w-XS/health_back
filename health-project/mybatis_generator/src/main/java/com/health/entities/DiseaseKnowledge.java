package com.health.entities;

import javax.persistence.*;

/**
 * 表名：chronic_disease_knowledge
 * 表注释：慢性病知识库
*/
@Table(name = "chronic_disease_knowledge")
public class DiseaseKnowledge {
    /**
     * 慢性病ID
     */
    @Id
    @Column(name = "disease_id")
    private Integer diseaseId;

    /**
     * 慢性病名
     */
    @Column(name = "disease_name")
    private String diseaseName;

    /**
     * 诱发原因
     */
    private String causes;

    /**
     * 危害性
     */
    private String harmfulness;

    /**
     * 正确预防
     */
    private String prevention;

    /**
     * 获取慢性病ID
     *
     * @return diseaseId - 慢性病ID
     */
    public Integer getDiseaseId() {
        return diseaseId;
    }

    /**
     * 设置慢性病ID
     *
     * @param diseaseId 慢性病ID
     */
    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * 获取慢性病名
     *
     * @return diseaseName - 慢性病名
     */
    public String getDiseaseName() {
        return diseaseName;
    }

    /**
     * 设置慢性病名
     *
     * @param diseaseName 慢性病名
     */
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    /**
     * 获取诱发原因
     *
     * @return causes - 诱发原因
     */
    public String getCauses() {
        return causes;
    }

    /**
     * 设置诱发原因
     *
     * @param causes 诱发原因
     */
    public void setCauses(String causes) {
        this.causes = causes;
    }

    /**
     * 获取危害性
     *
     * @return harmfulness - 危害性
     */
    public String getHarmfulness() {
        return harmfulness;
    }

    /**
     * 设置危害性
     *
     * @param harmfulness 危害性
     */
    public void setHarmfulness(String harmfulness) {
        this.harmfulness = harmfulness;
    }

    /**
     * 获取正确预防
     *
     * @return prevention - 正确预防
     */
    public String getPrevention() {
        return prevention;
    }

    /**
     * 设置正确预防
     *
     * @param prevention 正确预防
     */
    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }
}