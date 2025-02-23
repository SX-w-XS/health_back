package com.health.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.dto
 * @Author: X_X
 * @Description: 糖尿病
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "预测糖尿病参数模型")
public class UserPredictDMDTO {

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名")
    private  String userName;
    @ApiModelProperty("用户性别")
    private  String userSex;
    @ApiModelProperty("用户年龄")
    private  Double userAge;

    @ApiModelProperty("是否高血压1表示有高血压0表示无")
    private  Double HighBP;

    @ApiModelProperty("是否高胆固醇")
    private Double HighChol;

    @ApiModelProperty("是否进行过胆固醇检查，1表示进行过，0表示未进行")
    private Double CholCheck;

    @ApiModelProperty("BMI")
    private Double BMI;

    @ApiModelProperty("是否抽烟")
    private Double Smoker;

    @ApiModelProperty("是否有中风病史1表示有0表示无")
    private Double Stroke;

    @ApiModelProperty("是否患有心脏病或有过发作，1表示有，0表示无")
    private Double HeartDiseaseorAttack;

    @ApiModelProperty("是否有体育活动，1表示有，0表示无")
    private Double PhysActivity;

    @ApiModelProperty("是否经常食用水果，1表示经常，0表示不经常")
    private  Double Fruits;

    @ApiModelProperty("是否经常食用蔬菜，1表示经常，0表示不经常")
    private Double Veggies;

    @ApiModelProperty("是否经常饮酒，1表示经常0表示不经常")
    private Double HvyAlcoholConsump;

    @ApiModelProperty("是否有任何形式医疗保健，1表示有，0表示无")
    private Double AnyHealthcare;

    @ApiModelProperty("否因费用问题没看医生，1表示是，0表示否")
    private Double NoDocbcCost;

    @ApiModelProperty("“General Health”缩写，数值或表总体健康等级1-5")
    private Double GenHlth;

    @ApiModelProperty("“Mental Health”缩写，数值或表过去一段时间心理不健康天数")
    private Double MentHlth;

    @ApiModelProperty("“Physical Health”缩写，数值或表过去一段时间身体不健康天数")
    private Double PhysHlth;

    @ApiModelProperty("是否有行走困难，1表示有，0表示无")
    private Double DiffWalk;

    @ApiModelProperty("教育程度，不同数值或代表不同教育阶段")
    private Double Education;

    @ApiModelProperty("收入水平，不同数值或代表不同收入水平")
    private Double Income;

}
