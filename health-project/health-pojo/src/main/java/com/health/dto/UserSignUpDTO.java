package com.health.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.dto
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpDTO  implements Serializable {
    private String nickname;
    private String userImg;
    private String password;
    private String phone;
    private String email;
    private Integer userSex;
    private String userNumber;
    private String username;
    private String userAge;
}
