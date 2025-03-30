package com.health.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * 表名：chd_record
 * 表注释：冠心病记录表
*/
@Table(name = "chd_record")
public class ChdRecord {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

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
     * 用户性别
     */
    @Column(name = "userSex")
    private String usersex;

    /**
     * 性别
     */
    private Double gender;

    /**
     * 多尿
     */
    private Double polyuria;

    /**
     * 多尿
     */
    private Double polydipsia;

    /**
     * 体重下降
     */
    @Column(name = "sundden_weight_less")
    private Double sunddenWeightLess;

    /**
     * 是否虚弱
     */
    private Double weakness;

    /**
     * 多食
     */
    private Double polyphagia;

    /**
     * 生殖器念珠菌
     */
    @Column(name = "genital_thrush")
    private Double genitalThrush;

    /**
     * 延迟治愈
     */
    @Column(name = "delayed_healing")
    private Double delayedHealing;

    /**
     * 视力模糊
     */
    @Column(name = "visual_blurring")
    private Double visualBlurring;

    /**
     * 易怒
     */
    private Double irritability;

    /**
     * 四肢麻木
     */
    @Column(name = "partial_paresis")
    private Double partialParesis;

    /**
     * 肌肉萎缩
     */
    @Column(name = "muscle_stiff")
    private Double muscleStiff;

    /**
     * 脱发
     */
    private Double alopecia;

    /**
     * 肥胖
     */
    private Integer obesity;

    /**
     * 加权分数
     */
    private Integer score;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 年龄
     */
    @Column(name = "userAge")
    private Integer userage;

    /**
     * 皮肤瘙痒
     */
    private Double itching;

    /**
     * 体重
     */
    private Double weight;

    /**
     * 高
     */
    private Double height;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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

    /**
     * 获取用户性别
     *
     * @return usersex - 用户性别
     */
    public String getUsersex() {
        return usersex;
    }

    /**
     * 设置用户性别
     *
     * @param usersex 用户性别
     */
    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Double getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Double gender) {
        this.gender = gender;
    }

    /**
     * 获取多尿
     *
     * @return polyuria - 多尿
     */
    public Double getPolyuria() {
        return polyuria;
    }

    /**
     * 设置多尿
     *
     * @param polyuria 多尿
     */
    public void setPolyuria(Double polyuria) {
        this.polyuria = polyuria;
    }

    /**
     * 获取多尿
     *
     * @return polydipsia - 多尿
     */
    public Double getPolydipsia() {
        return polydipsia;
    }

    /**
     * 设置多尿
     *
     * @param polydipsia 多尿
     */
    public void setPolydipsia(Double polydipsia) {
        this.polydipsia = polydipsia;
    }

    /**
     * 获取体重下降
     *
     * @return sunddenWeightLess - 体重下降
     */
    public Double getSunddenWeightLess() {
        return sunddenWeightLess;
    }

    /**
     * 设置体重下降
     *
     * @param sunddenWeightLess 体重下降
     */
    public void setSunddenWeightLess(Double sunddenWeightLess) {
        this.sunddenWeightLess = sunddenWeightLess;
    }

    /**
     * 获取是否虚弱
     *
     * @return weakness - 是否虚弱
     */
    public Double getWeakness() {
        return weakness;
    }

    /**
     * 设置是否虚弱
     *
     * @param weakness 是否虚弱
     */
    public void setWeakness(Double weakness) {
        this.weakness = weakness;
    }

    /**
     * 获取多食
     *
     * @return polyphagia - 多食
     */
    public Double getPolyphagia() {
        return polyphagia;
    }

    /**
     * 设置多食
     *
     * @param polyphagia 多食
     */
    public void setPolyphagia(Double polyphagia) {
        this.polyphagia = polyphagia;
    }

    /**
     * 获取生殖器念珠菌
     *
     * @return genitalThrush - 生殖器念珠菌
     */
    public Double getGenitalThrush() {
        return genitalThrush;
    }

    /**
     * 设置生殖器念珠菌
     *
     * @param genitalThrush 生殖器念珠菌
     */
    public void setGenitalThrush(Double genitalThrush) {
        this.genitalThrush = genitalThrush;
    }

    /**
     * 获取延迟治愈
     *
     * @return delayedHealing - 延迟治愈
     */
    public Double getDelayedHealing() {
        return delayedHealing;
    }

    /**
     * 设置延迟治愈
     *
     * @param delayedHealing 延迟治愈
     */
    public void setDelayedHealing(Double delayedHealing) {
        this.delayedHealing = delayedHealing;
    }

    /**
     * 获取视力模糊
     *
     * @return visualBlurring - 视力模糊
     */
    public Double getVisualBlurring() {
        return visualBlurring;
    }

    /**
     * 设置视力模糊
     *
     * @param visualBlurring 视力模糊
     */
    public void setVisualBlurring(Double visualBlurring) {
        this.visualBlurring = visualBlurring;
    }

    /**
     * 获取易怒
     *
     * @return irritability - 易怒
     */
    public Double getIrritability() {
        return irritability;
    }

    /**
     * 设置易怒
     *
     * @param irritability 易怒
     */
    public void setIrritability(Double irritability) {
        this.irritability = irritability;
    }

    /**
     * 获取四肢麻木
     *
     * @return partialParesis - 四肢麻木
     */
    public Double getPartialParesis() {
        return partialParesis;
    }

    /**
     * 设置四肢麻木
     *
     * @param partialParesis 四肢麻木
     */
    public void setPartialParesis(Double partialParesis) {
        this.partialParesis = partialParesis;
    }

    /**
     * 获取肌肉萎缩
     *
     * @return muscleStiff - 肌肉萎缩
     */
    public Double getMuscleStiff() {
        return muscleStiff;
    }

    /**
     * 设置肌肉萎缩
     *
     * @param muscleStiff 肌肉萎缩
     */
    public void setMuscleStiff(Double muscleStiff) {
        this.muscleStiff = muscleStiff;
    }

    /**
     * 获取脱发
     *
     * @return alopecia - 脱发
     */
    public Double getAlopecia() {
        return alopecia;
    }

    /**
     * 设置脱发
     *
     * @param alopecia 脱发
     */
    public void setAlopecia(Double alopecia) {
        this.alopecia = alopecia;
    }

    /**
     * 获取肥胖
     *
     * @return obesity - 肥胖
     */
    public Integer getObesity() {
        return obesity;
    }

    /**
     * 设置肥胖
     *
     * @param obesity 肥胖
     */
    public void setObesity(Integer obesity) {
        this.obesity = obesity;
    }

    /**
     * 获取加权分数
     *
     * @return score - 加权分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置加权分数
     *
     * @param score 加权分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取年龄
     *
     * @return userage - 年龄
     */
    public Integer getUserage() {
        return userage;
    }

    /**
     * 设置年龄
     *
     * @param userage 年龄
     */
    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    /**
     * 获取皮肤瘙痒
     *
     * @return itching - 皮肤瘙痒
     */
    public Double getItching() {
        return itching;
    }

    /**
     * 设置皮肤瘙痒
     *
     * @param itching 皮肤瘙痒
     */
    public void setItching(Double itching) {
        this.itching = itching;
    }

    /**
     * 获取体重
     *
     * @return weight - 体重
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置体重
     *
     * @param weight 体重
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 获取高
     *
     * @return height - 高
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 设置高
     *
     * @param height 高
     */
    public void setHeight(Double height) {
        this.height = height;
    }
}