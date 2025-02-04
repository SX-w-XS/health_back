package com.health.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.vo
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredictDMVO implements Serializable {
    private Double probability0;
    private Double probability1;
    private Double probability2;
}