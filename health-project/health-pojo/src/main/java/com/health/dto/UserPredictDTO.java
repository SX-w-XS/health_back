package com.health.dto;

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
public class UserPredictDTO implements Serializable {
    private Integer userId;

    private  String userName;
    private  String userSex;

    private  Double userAge;

    private  Double genderFemale;

    private  Double genderMale;

    private Double polyuriaNo;
    private Double polyuriaYes;

    private Double polydipsiaNo;
    private Double polydipsiaYes;

    private Double suddenWeightLossNo;
    private Double suddenWeightLossYes;

    private Double weaknessNo;
    private Double weaknessYes;

    private Double polyphagiaNo;
    private Double polyphagiaYes;

    private Double genitalThrushNo;
    private Double genitalThrushYes;

    private Double visualBlurringNo;
    private Double visualBlurringYes;

    private Double ItchingNo;
    private Double ItchingYes;

    private Double irritabilityNo;
    private Double irritabilityYes;

    private Double delayedHealingNo;
    private Double delayedHealingYes;

    private Double partialParesisNo;
    private Double partialParesisYes;

    private Double muscleStiffnessNo;
    private Double muscleStiffnessYes;

    private Double alopeciaNo;
    private Double alopeciaYes;

    private Double obesityNo;
    private Double obesityYes;


}
