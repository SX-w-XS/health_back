package com.health.service;

import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.dto.UserSignUpDTO;
import com.health.entities.User;
import com.health.vo.UserVO;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserService {
    User login(UserLoginDTO userLoginDTO);

    void register(UserSignUpDTO userSignUpDTO);

    UserVO queryById(String id);

    void update(UserDTO user);
}
