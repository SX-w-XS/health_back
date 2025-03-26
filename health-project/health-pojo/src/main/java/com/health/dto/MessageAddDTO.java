package com.health.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.dto
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@ApiModel(description = "添加信息")
public class MessageAddDTO {
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 跳转url
     */
    @ApiModelProperty("跳转url")
    private String url;

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
