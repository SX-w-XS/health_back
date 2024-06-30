package com.health.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.entity
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{
 private Integer userId;
 private String nickName;
 private String userImg;
 private String password;
 private String phone;
 private String email;
 private Integer userSex;
 private String userNumber;
 private String userName;
 private String userAge;
 private Integer role;
 private Date registerDate;
}
