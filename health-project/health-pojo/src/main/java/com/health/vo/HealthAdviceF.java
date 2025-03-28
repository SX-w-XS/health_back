package com.health.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class HealthAdviceF {
    private List<HealthAdviceVO> healthAdviceList;
    private String suggestion;
}
