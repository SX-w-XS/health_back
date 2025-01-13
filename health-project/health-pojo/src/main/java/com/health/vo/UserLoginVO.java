package com.health.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
@ApiModel(description = "员工登录返回的数据格式")
public class UserLoginVO implements Serializable {
    @ApiModelProperty("主键值")
    private Long userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("姓名")
    private String nickname;

    @ApiModelProperty("用户头像")
    private String userImg;

    @ApiModelProperty("jwt令牌")
    private String token;
}
