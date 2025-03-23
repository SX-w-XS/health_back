package com.health.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.dto
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
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


    @ApiModelProperty("创建时间")
    private Date createtime;

}
