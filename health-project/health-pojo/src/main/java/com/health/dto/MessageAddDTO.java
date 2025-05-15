package com.health.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;  //通过注解自动生成 Java 类的 getter、setter、toString、equals 和 hashCode 等方法

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
@ApiModel(description = "添加信息") //Swagger 的注解，用于为该类添加描述信息，在生成 API 文档时，会显示该描述信息
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
