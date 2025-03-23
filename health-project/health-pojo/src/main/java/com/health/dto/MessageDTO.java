package com.health.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

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
@ApiModel(description = "消息传输对象")
public class MessageDTO {
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;



    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private Integer kind;



    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;
}
