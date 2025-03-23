package com.health.dto;

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
    private String title;

    /**
     * 跳转url
     */
    private String url;

    /**
     * 类型
     */
    private Integer kind;


    /**
     * 内容
     */
    private String content;


    private Date createtime;

}
