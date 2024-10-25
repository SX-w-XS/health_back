package com.health.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.dto
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class UserPageDTO implements Serializable {

    //姓名
    private String name;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}