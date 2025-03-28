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
public class HealthAdviceVO {
    private String category;
    private String title;
    private String content;
    private int priority;
}
