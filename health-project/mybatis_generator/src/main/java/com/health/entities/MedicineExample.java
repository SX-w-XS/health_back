package com.health.entities;

import java.util.ArrayList;
import java.util.List;

public class MedicineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedicineExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMedicineIdIsNull() {
            addCriterion("medicine_id is null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIsNotNull() {
            addCriterion("medicine_id is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineIdEqualTo(Integer value) {
            addCriterion("medicine_id =", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotEqualTo(Integer value) {
            addCriterion("medicine_id <>", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThan(Integer value) {
            addCriterion("medicine_id >", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicine_id >=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThan(Integer value) {
            addCriterion("medicine_id <", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdLessThanOrEqualTo(Integer value) {
            addCriterion("medicine_id <=", value, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdIn(List<Integer> values) {
            addCriterion("medicine_id in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotIn(List<Integer> values) {
            addCriterion("medicine_id not in", values, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdBetween(Integer value1, Integer value2) {
            addCriterion("medicine_id between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("medicine_id not between", value1, value2, "medicineId");
            return (Criteria) this;
        }

        public Criteria andMedicalNameIsNull() {
            addCriterion("medical_name is null");
            return (Criteria) this;
        }

        public Criteria andMedicalNameIsNotNull() {
            addCriterion("medical_name is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalNameEqualTo(String value) {
            addCriterion("medical_name =", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameNotEqualTo(String value) {
            addCriterion("medical_name <>", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameGreaterThan(String value) {
            addCriterion("medical_name >", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameGreaterThanOrEqualTo(String value) {
            addCriterion("medical_name >=", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameLessThan(String value) {
            addCriterion("medical_name <", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameLessThanOrEqualTo(String value) {
            addCriterion("medical_name <=", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameLike(String value) {
            addCriterion("medical_name like", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameNotLike(String value) {
            addCriterion("medical_name not like", value, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameIn(List<String> values) {
            addCriterion("medical_name in", values, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameNotIn(List<String> values) {
            addCriterion("medical_name not in", values, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameBetween(String value1, String value2) {
            addCriterion("medical_name between", value1, value2, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalNameNotBetween(String value1, String value2) {
            addCriterion("medical_name not between", value1, value2, "medicalName");
            return (Criteria) this;
        }

        public Criteria andMedicalImgIsNull() {
            addCriterion("medical_img is null");
            return (Criteria) this;
        }

        public Criteria andMedicalImgIsNotNull() {
            addCriterion("medical_img is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalImgEqualTo(String value) {
            addCriterion("medical_img =", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgNotEqualTo(String value) {
            addCriterion("medical_img <>", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgGreaterThan(String value) {
            addCriterion("medical_img >", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgGreaterThanOrEqualTo(String value) {
            addCriterion("medical_img >=", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgLessThan(String value) {
            addCriterion("medical_img <", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgLessThanOrEqualTo(String value) {
            addCriterion("medical_img <=", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgLike(String value) {
            addCriterion("medical_img like", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgNotLike(String value) {
            addCriterion("medical_img not like", value, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgIn(List<String> values) {
            addCriterion("medical_img in", values, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgNotIn(List<String> values) {
            addCriterion("medical_img not in", values, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgBetween(String value1, String value2) {
            addCriterion("medical_img between", value1, value2, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andMedicalImgNotBetween(String value1, String value2) {
            addCriterion("medical_img not between", value1, value2, "medicalImg");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupIsNull() {
            addCriterion("cautionary_group is null");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupIsNotNull() {
            addCriterion("cautionary_group is not null");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupEqualTo(String value) {
            addCriterion("cautionary_group =", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupNotEqualTo(String value) {
            addCriterion("cautionary_group <>", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupGreaterThan(String value) {
            addCriterion("cautionary_group >", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupGreaterThanOrEqualTo(String value) {
            addCriterion("cautionary_group >=", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupLessThan(String value) {
            addCriterion("cautionary_group <", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupLessThanOrEqualTo(String value) {
            addCriterion("cautionary_group <=", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupLike(String value) {
            addCriterion("cautionary_group like", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupNotLike(String value) {
            addCriterion("cautionary_group not like", value, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupIn(List<String> values) {
            addCriterion("cautionary_group in", values, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupNotIn(List<String> values) {
            addCriterion("cautionary_group not in", values, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupBetween(String value1, String value2) {
            addCriterion("cautionary_group between", value1, value2, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andCautionaryGroupNotBetween(String value1, String value2) {
            addCriterion("cautionary_group not between", value1, value2, "cautionaryGroup");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNull() {
            addCriterion("disease_id is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(Integer value) {
            addCriterion("disease_id =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(Integer value) {
            addCriterion("disease_id <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(Integer value) {
            addCriterion("disease_id >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disease_id >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(Integer value) {
            addCriterion("disease_id <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("disease_id <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<Integer> values) {
            addCriterion("disease_id in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<Integer> values) {
            addCriterion("disease_id not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("disease_id between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disease_id not between", value1, value2, "diseaseId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}