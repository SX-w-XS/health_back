package com.health.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.dto
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "预测冠心病参数模型")
public class UserPredictDTO implements Serializable {
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名")
    private  String userName;
    @ApiModelProperty("用户性别")
    private  String userSex;
    @ApiModelProperty("用户年龄")
    private  Double userAge;
    @ApiModelProperty("是否男性 1 0 -1 （1 是 0 不清楚 -1不是  ")
    private  Double genderFemale;
    @ApiModelProperty("是否女性")
    private  Double genderMale;
    @ApiModelProperty("是否多尿")
    private Double polyuriaNo;
    private Double polyuriaYes;
    @ApiModelProperty("是否多饮")
    private Double polydipsiaNo;
    private Double polydipsiaYes;
    @ApiModelProperty("是否体重下降")
    private Double suddenWeightLossNo;
    private Double suddenWeightLossYes;

    @ApiModelProperty("是否虚弱无力")
    private Double weaknessNo;
    private Double weaknessYes;

    @ApiModelProperty("是否多食")
    private Double polyphagiaNo;
    private Double polyphagiaYes;

    @ApiModelProperty("是否生殖器念珠菌病")
    private Double genitalThrushNo;
    private Double genitalThrushYes;

     @ApiModelProperty("是否视力模糊")
    private Double visualBlurringNo;
    private Double visualBlurringYes;

    @ApiModelProperty("是否皮肤瘙痒")
    private Double ItchingNo;
    private Double ItchingYes;

    @ApiModelProperty("是否易怒")
    private Double irritabilityNo;
    private Double irritabilityYes;

    @ApiModelProperty("是否出现愈合延迟")
    private Double delayedHealingNo;
    private Double delayedHealingYes;

    @ApiModelProperty("是否四肢麻木")
    private Double partialParesisNo;
    private Double partialParesisYes;

    @ApiModelProperty("是否肌肉萎缩")
    private Double muscleStiffnessNo;
    private Double muscleStiffnessYes;

    @ApiModelProperty("是否脱发")
    private Double alopeciaNo;
    private Double alopeciaYes;

    @ApiModelProperty("是否肥胖")
    private Double obesityNo;
    private Double obesityYes;


}
