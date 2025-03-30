package com.health.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class CountUserVO {
    private  Integer total;
    private  Integer man;
    private  Integer woman;
    private  Integer predictCount;
    private  Integer highLevelCVD;
    private  Integer lowLevelCVD;
    private  Integer midLevelCVD;
    private  Integer highProLevelCVD;
    private  Integer messageCount;
}
