package com.health.entities;


/**
 * 表名：medicine
 * 表注释：药物表
*/

public class Medicine {

    private Integer medicineId;


    private String medicalName;


    private String medicalImg;

    private String cautionaryGroup;

    private Integer diseaseId;

    private String adaptations;

    private String useage;

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicalName() {
        return medicalName;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public String getMedicalImg() {
        return medicalImg;
    }

    public void setMedicalImg(String medicalImg) {
        this.medicalImg = medicalImg;
    }

    public String getCautionaryGroup() {
        return cautionaryGroup;
    }

    public void setCautionaryGroup(String cautionaryGroup) {
        this.cautionaryGroup = cautionaryGroup;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getAdaptations() {
        return adaptations;
    }

    public void setAdaptations(String adaptations) {
        this.adaptations = adaptations;
    }

    public String getUseage() {
        return useage;
    }

    public void setUseage(String useage) {
        this.useage = useage;
    }
}