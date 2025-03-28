package com.health.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "获取建议")
public class SuggestionVO {

    private String suggestion;
    private String score;
}
