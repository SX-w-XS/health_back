package com.health.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChdRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChdRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPositiveIsNull() {
            addCriterion("positive is null");
            return (Criteria) this;
        }

        public Criteria andPositiveIsNotNull() {
            addCriterion("positive is not null");
            return (Criteria) this;
        }

        public Criteria andPositiveEqualTo(Double value) {
            addCriterion("positive =", value, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveNotEqualTo(Double value) {
            addCriterion("positive <>", value, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveGreaterThan(Double value) {
            addCriterion("positive >", value, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveGreaterThanOrEqualTo(Double value) {
            addCriterion("positive >=", value, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveLessThan(Double value) {
            addCriterion("positive <", value, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveLessThanOrEqualTo(Double value) {
            addCriterion("positive <=", value, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveIn(List<Double> values) {
            addCriterion("positive in", values, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveNotIn(List<Double> values) {
            addCriterion("positive not in", values, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveBetween(Double value1, Double value2) {
            addCriterion("positive between", value1, value2, "positive");
            return (Criteria) this;
        }

        public Criteria andPositiveNotBetween(Double value1, Double value2) {
            addCriterion("positive not between", value1, value2, "positive");
            return (Criteria) this;
        }

        public Criteria andNegativeIsNull() {
            addCriterion("negative is null");
            return (Criteria) this;
        }

        public Criteria andNegativeIsNotNull() {
            addCriterion("negative is not null");
            return (Criteria) this;
        }

        public Criteria andNegativeEqualTo(Double value) {
            addCriterion("negative =", value, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeNotEqualTo(Double value) {
            addCriterion("negative <>", value, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeGreaterThan(Double value) {
            addCriterion("negative >", value, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeGreaterThanOrEqualTo(Double value) {
            addCriterion("negative >=", value, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeLessThan(Double value) {
            addCriterion("negative <", value, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeLessThanOrEqualTo(Double value) {
            addCriterion("negative <=", value, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeIn(List<Double> values) {
            addCriterion("negative in", values, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeNotIn(List<Double> values) {
            addCriterion("negative not in", values, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeBetween(Double value1, Double value2) {
            addCriterion("negative between", value1, value2, "negative");
            return (Criteria) this;
        }

        public Criteria andNegativeNotBetween(Double value1, Double value2) {
            addCriterion("negative not between", value1, value2, "negative");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNull() {
            addCriterion("userSex is null");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNotNull() {
            addCriterion("userSex is not null");
            return (Criteria) this;
        }

        public Criteria andUsersexEqualTo(String value) {
            addCriterion("userSex =", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotEqualTo(String value) {
            addCriterion("userSex <>", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThan(String value) {
            addCriterion("userSex >", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThanOrEqualTo(String value) {
            addCriterion("userSex >=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThan(String value) {
            addCriterion("userSex <", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThanOrEqualTo(String value) {
            addCriterion("userSex <=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLike(String value) {
            addCriterion("userSex like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotLike(String value) {
            addCriterion("userSex not like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexIn(List<String> values) {
            addCriterion("userSex in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotIn(List<String> values) {
            addCriterion("userSex not in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexBetween(String value1, String value2) {
            addCriterion("userSex between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotBetween(String value1, String value2) {
            addCriterion("userSex not between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Double value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Double value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Double value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Double value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Double value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Double value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Double> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Double> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Double value1, Double value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Double value1, Double value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andPolyuriaIsNull() {
            addCriterion("polyuria is null");
            return (Criteria) this;
        }

        public Criteria andPolyuriaIsNotNull() {
            addCriterion("polyuria is not null");
            return (Criteria) this;
        }

        public Criteria andPolyuriaEqualTo(Double value) {
            addCriterion("polyuria =", value, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaNotEqualTo(Double value) {
            addCriterion("polyuria <>", value, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaGreaterThan(Double value) {
            addCriterion("polyuria >", value, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaGreaterThanOrEqualTo(Double value) {
            addCriterion("polyuria >=", value, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaLessThan(Double value) {
            addCriterion("polyuria <", value, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaLessThanOrEqualTo(Double value) {
            addCriterion("polyuria <=", value, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaIn(List<Double> values) {
            addCriterion("polyuria in", values, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaNotIn(List<Double> values) {
            addCriterion("polyuria not in", values, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaBetween(Double value1, Double value2) {
            addCriterion("polyuria between", value1, value2, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolyuriaNotBetween(Double value1, Double value2) {
            addCriterion("polyuria not between", value1, value2, "polyuria");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaIsNull() {
            addCriterion("polydipsia is null");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaIsNotNull() {
            addCriterion("polydipsia is not null");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaEqualTo(Double value) {
            addCriterion("polydipsia =", value, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaNotEqualTo(Double value) {
            addCriterion("polydipsia <>", value, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaGreaterThan(Double value) {
            addCriterion("polydipsia >", value, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaGreaterThanOrEqualTo(Double value) {
            addCriterion("polydipsia >=", value, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaLessThan(Double value) {
            addCriterion("polydipsia <", value, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaLessThanOrEqualTo(Double value) {
            addCriterion("polydipsia <=", value, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaIn(List<Double> values) {
            addCriterion("polydipsia in", values, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaNotIn(List<Double> values) {
            addCriterion("polydipsia not in", values, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaBetween(Double value1, Double value2) {
            addCriterion("polydipsia between", value1, value2, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andPolydipsiaNotBetween(Double value1, Double value2) {
            addCriterion("polydipsia not between", value1, value2, "polydipsia");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessIsNull() {
            addCriterion("sundden_weight_less is null");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessIsNotNull() {
            addCriterion("sundden_weight_less is not null");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessEqualTo(Double value) {
            addCriterion("sundden_weight_less =", value, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessNotEqualTo(Double value) {
            addCriterion("sundden_weight_less <>", value, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessGreaterThan(Double value) {
            addCriterion("sundden_weight_less >", value, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessGreaterThanOrEqualTo(Double value) {
            addCriterion("sundden_weight_less >=", value, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessLessThan(Double value) {
            addCriterion("sundden_weight_less <", value, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessLessThanOrEqualTo(Double value) {
            addCriterion("sundden_weight_less <=", value, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessIn(List<Double> values) {
            addCriterion("sundden_weight_less in", values, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessNotIn(List<Double> values) {
            addCriterion("sundden_weight_less not in", values, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessBetween(Double value1, Double value2) {
            addCriterion("sundden_weight_less between", value1, value2, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andSunddenWeightLessNotBetween(Double value1, Double value2) {
            addCriterion("sundden_weight_less not between", value1, value2, "sunddenWeightLess");
            return (Criteria) this;
        }

        public Criteria andWeaknessIsNull() {
            addCriterion("weakness is null");
            return (Criteria) this;
        }

        public Criteria andWeaknessIsNotNull() {
            addCriterion("weakness is not null");
            return (Criteria) this;
        }

        public Criteria andWeaknessEqualTo(Double value) {
            addCriterion("weakness =", value, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessNotEqualTo(Double value) {
            addCriterion("weakness <>", value, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessGreaterThan(Double value) {
            addCriterion("weakness >", value, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessGreaterThanOrEqualTo(Double value) {
            addCriterion("weakness >=", value, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessLessThan(Double value) {
            addCriterion("weakness <", value, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessLessThanOrEqualTo(Double value) {
            addCriterion("weakness <=", value, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessIn(List<Double> values) {
            addCriterion("weakness in", values, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessNotIn(List<Double> values) {
            addCriterion("weakness not in", values, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessBetween(Double value1, Double value2) {
            addCriterion("weakness between", value1, value2, "weakness");
            return (Criteria) this;
        }

        public Criteria andWeaknessNotBetween(Double value1, Double value2) {
            addCriterion("weakness not between", value1, value2, "weakness");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaIsNull() {
            addCriterion("polyphagia is null");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaIsNotNull() {
            addCriterion("polyphagia is not null");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaEqualTo(Double value) {
            addCriterion("polyphagia =", value, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaNotEqualTo(Double value) {
            addCriterion("polyphagia <>", value, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaGreaterThan(Double value) {
            addCriterion("polyphagia >", value, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaGreaterThanOrEqualTo(Double value) {
            addCriterion("polyphagia >=", value, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaLessThan(Double value) {
            addCriterion("polyphagia <", value, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaLessThanOrEqualTo(Double value) {
            addCriterion("polyphagia <=", value, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaIn(List<Double> values) {
            addCriterion("polyphagia in", values, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaNotIn(List<Double> values) {
            addCriterion("polyphagia not in", values, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaBetween(Double value1, Double value2) {
            addCriterion("polyphagia between", value1, value2, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andPolyphagiaNotBetween(Double value1, Double value2) {
            addCriterion("polyphagia not between", value1, value2, "polyphagia");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushIsNull() {
            addCriterion("genital_thrush is null");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushIsNotNull() {
            addCriterion("genital_thrush is not null");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushEqualTo(Double value) {
            addCriterion("genital_thrush =", value, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushNotEqualTo(Double value) {
            addCriterion("genital_thrush <>", value, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushGreaterThan(Double value) {
            addCriterion("genital_thrush >", value, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushGreaterThanOrEqualTo(Double value) {
            addCriterion("genital_thrush >=", value, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushLessThan(Double value) {
            addCriterion("genital_thrush <", value, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushLessThanOrEqualTo(Double value) {
            addCriterion("genital_thrush <=", value, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushIn(List<Double> values) {
            addCriterion("genital_thrush in", values, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushNotIn(List<Double> values) {
            addCriterion("genital_thrush not in", values, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushBetween(Double value1, Double value2) {
            addCriterion("genital_thrush between", value1, value2, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andGenitalThrushNotBetween(Double value1, Double value2) {
            addCriterion("genital_thrush not between", value1, value2, "genitalThrush");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingIsNull() {
            addCriterion("delayed_healing is null");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingIsNotNull() {
            addCriterion("delayed_healing is not null");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingEqualTo(Double value) {
            addCriterion("delayed_healing =", value, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingNotEqualTo(Double value) {
            addCriterion("delayed_healing <>", value, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingGreaterThan(Double value) {
            addCriterion("delayed_healing >", value, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingGreaterThanOrEqualTo(Double value) {
            addCriterion("delayed_healing >=", value, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingLessThan(Double value) {
            addCriterion("delayed_healing <", value, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingLessThanOrEqualTo(Double value) {
            addCriterion("delayed_healing <=", value, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingIn(List<Double> values) {
            addCriterion("delayed_healing in", values, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingNotIn(List<Double> values) {
            addCriterion("delayed_healing not in", values, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingBetween(Double value1, Double value2) {
            addCriterion("delayed_healing between", value1, value2, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andDelayedHealingNotBetween(Double value1, Double value2) {
            addCriterion("delayed_healing not between", value1, value2, "delayedHealing");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringIsNull() {
            addCriterion("visual_blurring is null");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringIsNotNull() {
            addCriterion("visual_blurring is not null");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringEqualTo(Double value) {
            addCriterion("visual_blurring =", value, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringNotEqualTo(Double value) {
            addCriterion("visual_blurring <>", value, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringGreaterThan(Double value) {
            addCriterion("visual_blurring >", value, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringGreaterThanOrEqualTo(Double value) {
            addCriterion("visual_blurring >=", value, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringLessThan(Double value) {
            addCriterion("visual_blurring <", value, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringLessThanOrEqualTo(Double value) {
            addCriterion("visual_blurring <=", value, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringIn(List<Double> values) {
            addCriterion("visual_blurring in", values, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringNotIn(List<Double> values) {
            addCriterion("visual_blurring not in", values, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringBetween(Double value1, Double value2) {
            addCriterion("visual_blurring between", value1, value2, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andVisualBlurringNotBetween(Double value1, Double value2) {
            addCriterion("visual_blurring not between", value1, value2, "visualBlurring");
            return (Criteria) this;
        }

        public Criteria andIrritabilityIsNull() {
            addCriterion("irritability is null");
            return (Criteria) this;
        }

        public Criteria andIrritabilityIsNotNull() {
            addCriterion("irritability is not null");
            return (Criteria) this;
        }

        public Criteria andIrritabilityEqualTo(Double value) {
            addCriterion("irritability =", value, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityNotEqualTo(Double value) {
            addCriterion("irritability <>", value, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityGreaterThan(Double value) {
            addCriterion("irritability >", value, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityGreaterThanOrEqualTo(Double value) {
            addCriterion("irritability >=", value, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityLessThan(Double value) {
            addCriterion("irritability <", value, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityLessThanOrEqualTo(Double value) {
            addCriterion("irritability <=", value, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityIn(List<Double> values) {
            addCriterion("irritability in", values, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityNotIn(List<Double> values) {
            addCriterion("irritability not in", values, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityBetween(Double value1, Double value2) {
            addCriterion("irritability between", value1, value2, "irritability");
            return (Criteria) this;
        }

        public Criteria andIrritabilityNotBetween(Double value1, Double value2) {
            addCriterion("irritability not between", value1, value2, "irritability");
            return (Criteria) this;
        }

        public Criteria andPartialParesisIsNull() {
            addCriterion("partial_paresis is null");
            return (Criteria) this;
        }

        public Criteria andPartialParesisIsNotNull() {
            addCriterion("partial_paresis is not null");
            return (Criteria) this;
        }

        public Criteria andPartialParesisEqualTo(Double value) {
            addCriterion("partial_paresis =", value, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisNotEqualTo(Double value) {
            addCriterion("partial_paresis <>", value, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisGreaterThan(Double value) {
            addCriterion("partial_paresis >", value, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisGreaterThanOrEqualTo(Double value) {
            addCriterion("partial_paresis >=", value, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisLessThan(Double value) {
            addCriterion("partial_paresis <", value, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisLessThanOrEqualTo(Double value) {
            addCriterion("partial_paresis <=", value, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisIn(List<Double> values) {
            addCriterion("partial_paresis in", values, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisNotIn(List<Double> values) {
            addCriterion("partial_paresis not in", values, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisBetween(Double value1, Double value2) {
            addCriterion("partial_paresis between", value1, value2, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andPartialParesisNotBetween(Double value1, Double value2) {
            addCriterion("partial_paresis not between", value1, value2, "partialParesis");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffIsNull() {
            addCriterion("muscle_stiff is null");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffIsNotNull() {
            addCriterion("muscle_stiff is not null");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffEqualTo(Double value) {
            addCriterion("muscle_stiff =", value, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffNotEqualTo(Double value) {
            addCriterion("muscle_stiff <>", value, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffGreaterThan(Double value) {
            addCriterion("muscle_stiff >", value, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffGreaterThanOrEqualTo(Double value) {
            addCriterion("muscle_stiff >=", value, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffLessThan(Double value) {
            addCriterion("muscle_stiff <", value, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffLessThanOrEqualTo(Double value) {
            addCriterion("muscle_stiff <=", value, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffIn(List<Double> values) {
            addCriterion("muscle_stiff in", values, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffNotIn(List<Double> values) {
            addCriterion("muscle_stiff not in", values, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffBetween(Double value1, Double value2) {
            addCriterion("muscle_stiff between", value1, value2, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andMuscleStiffNotBetween(Double value1, Double value2) {
            addCriterion("muscle_stiff not between", value1, value2, "muscleStiff");
            return (Criteria) this;
        }

        public Criteria andAlopeciaIsNull() {
            addCriterion("alopecia is null");
            return (Criteria) this;
        }

        public Criteria andAlopeciaIsNotNull() {
            addCriterion("alopecia is not null");
            return (Criteria) this;
        }

        public Criteria andAlopeciaEqualTo(Double value) {
            addCriterion("alopecia =", value, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaNotEqualTo(Double value) {
            addCriterion("alopecia <>", value, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaGreaterThan(Double value) {
            addCriterion("alopecia >", value, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaGreaterThanOrEqualTo(Double value) {
            addCriterion("alopecia >=", value, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaLessThan(Double value) {
            addCriterion("alopecia <", value, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaLessThanOrEqualTo(Double value) {
            addCriterion("alopecia <=", value, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaIn(List<Double> values) {
            addCriterion("alopecia in", values, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaNotIn(List<Double> values) {
            addCriterion("alopecia not in", values, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaBetween(Double value1, Double value2) {
            addCriterion("alopecia between", value1, value2, "alopecia");
            return (Criteria) this;
        }

        public Criteria andAlopeciaNotBetween(Double value1, Double value2) {
            addCriterion("alopecia not between", value1, value2, "alopecia");
            return (Criteria) this;
        }

        public Criteria andObesityIsNull() {
            addCriterion("obesity is null");
            return (Criteria) this;
        }

        public Criteria andObesityIsNotNull() {
            addCriterion("obesity is not null");
            return (Criteria) this;
        }

        public Criteria andObesityEqualTo(Integer value) {
            addCriterion("obesity =", value, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityNotEqualTo(Integer value) {
            addCriterion("obesity <>", value, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityGreaterThan(Integer value) {
            addCriterion("obesity >", value, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityGreaterThanOrEqualTo(Integer value) {
            addCriterion("obesity >=", value, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityLessThan(Integer value) {
            addCriterion("obesity <", value, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityLessThanOrEqualTo(Integer value) {
            addCriterion("obesity <=", value, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityIn(List<Integer> values) {
            addCriterion("obesity in", values, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityNotIn(List<Integer> values) {
            addCriterion("obesity not in", values, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityBetween(Integer value1, Integer value2) {
            addCriterion("obesity between", value1, value2, "obesity");
            return (Criteria) this;
        }

        public Criteria andObesityNotBetween(Integer value1, Integer value2) {
            addCriterion("obesity not between", value1, value2, "obesity");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUserageIsNull() {
            addCriterion("userAge is null");
            return (Criteria) this;
        }

        public Criteria andUserageIsNotNull() {
            addCriterion("userAge is not null");
            return (Criteria) this;
        }

        public Criteria andUserageEqualTo(Integer value) {
            addCriterion("userAge =", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageNotEqualTo(Integer value) {
            addCriterion("userAge <>", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageGreaterThan(Integer value) {
            addCriterion("userAge >", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageGreaterThanOrEqualTo(Integer value) {
            addCriterion("userAge >=", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageLessThan(Integer value) {
            addCriterion("userAge <", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageLessThanOrEqualTo(Integer value) {
            addCriterion("userAge <=", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageIn(List<Integer> values) {
            addCriterion("userAge in", values, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageNotIn(List<Integer> values) {
            addCriterion("userAge not in", values, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageBetween(Integer value1, Integer value2) {
            addCriterion("userAge between", value1, value2, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageNotBetween(Integer value1, Integer value2) {
            addCriterion("userAge not between", value1, value2, "userage");
            return (Criteria) this;
        }

        public Criteria andItchingIsNull() {
            addCriterion("itching is null");
            return (Criteria) this;
        }

        public Criteria andItchingIsNotNull() {
            addCriterion("itching is not null");
            return (Criteria) this;
        }

        public Criteria andItchingEqualTo(Double value) {
            addCriterion("itching =", value, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingNotEqualTo(Double value) {
            addCriterion("itching <>", value, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingGreaterThan(Double value) {
            addCriterion("itching >", value, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingGreaterThanOrEqualTo(Double value) {
            addCriterion("itching >=", value, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingLessThan(Double value) {
            addCriterion("itching <", value, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingLessThanOrEqualTo(Double value) {
            addCriterion("itching <=", value, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingIn(List<Double> values) {
            addCriterion("itching in", values, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingNotIn(List<Double> values) {
            addCriterion("itching not in", values, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingBetween(Double value1, Double value2) {
            addCriterion("itching between", value1, value2, "itching");
            return (Criteria) this;
        }

        public Criteria andItchingNotBetween(Double value1, Double value2) {
            addCriterion("itching not between", value1, value2, "itching");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Double value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Double value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Double value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Double value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Double value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Double value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Double> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Double> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Double value1, Double value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Double value1, Double value2) {
            addCriterion("height not between", value1, value2, "height");
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