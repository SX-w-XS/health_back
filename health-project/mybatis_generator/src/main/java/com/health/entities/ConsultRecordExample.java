package com.health.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsultRecordExample() {
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

        public Criteria andConsultationIdIsNull() {
            addCriterion("consultation_id is null");
            return (Criteria) this;
        }

        public Criteria andConsultationIdIsNotNull() {
            addCriterion("consultation_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationIdEqualTo(Integer value) {
            addCriterion("consultation_id =", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdNotEqualTo(Integer value) {
            addCriterion("consultation_id <>", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdGreaterThan(Integer value) {
            addCriterion("consultation_id >", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("consultation_id >=", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdLessThan(Integer value) {
            addCriterion("consultation_id <", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdLessThanOrEqualTo(Integer value) {
            addCriterion("consultation_id <=", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdIn(List<Integer> values) {
            addCriterion("consultation_id in", values, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdNotIn(List<Integer> values) {
            addCriterion("consultation_id not in", values, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdBetween(Integer value1, Integer value2) {
            addCriterion("consultation_id between", value1, value2, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("consultation_id not between", value1, value2, "consultationId");
            return (Criteria) this;
        }

        public Criteria andHUserIdIsNull() {
            addCriterion("h_user_id is null");
            return (Criteria) this;
        }

        public Criteria andHUserIdIsNotNull() {
            addCriterion("h_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andHUserIdEqualTo(Integer value) {
            addCriterion("h_user_id =", value, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdNotEqualTo(Integer value) {
            addCriterion("h_user_id <>", value, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdGreaterThan(Integer value) {
            addCriterion("h_user_id >", value, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("h_user_id >=", value, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdLessThan(Integer value) {
            addCriterion("h_user_id <", value, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("h_user_id <=", value, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdIn(List<Integer> values) {
            addCriterion("h_user_id in", values, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdNotIn(List<Integer> values) {
            addCriterion("h_user_id not in", values, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdBetween(Integer value1, Integer value2) {
            addCriterion("h_user_id between", value1, value2, "hUserId");
            return (Criteria) this;
        }

        public Criteria andHUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("h_user_id not between", value1, value2, "hUserId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(Integer value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(Integer value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(Integer value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(Integer value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<Integer> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<Integer> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andConsultDateIsNull() {
            addCriterion("consult_date is null");
            return (Criteria) this;
        }

        public Criteria andConsultDateIsNotNull() {
            addCriterion("consult_date is not null");
            return (Criteria) this;
        }

        public Criteria andConsultDateEqualTo(Date value) {
            addCriterion("consult_date =", value, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateNotEqualTo(Date value) {
            addCriterion("consult_date <>", value, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateGreaterThan(Date value) {
            addCriterion("consult_date >", value, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateGreaterThanOrEqualTo(Date value) {
            addCriterion("consult_date >=", value, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateLessThan(Date value) {
            addCriterion("consult_date <", value, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateLessThanOrEqualTo(Date value) {
            addCriterion("consult_date <=", value, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateIn(List<Date> values) {
            addCriterion("consult_date in", values, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateNotIn(List<Date> values) {
            addCriterion("consult_date not in", values, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateBetween(Date value1, Date value2) {
            addCriterion("consult_date between", value1, value2, "consultDate");
            return (Criteria) this;
        }

        public Criteria andConsultDateNotBetween(Date value1, Date value2) {
            addCriterion("consult_date not between", value1, value2, "consultDate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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