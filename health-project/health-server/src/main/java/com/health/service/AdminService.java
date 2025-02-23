package com.health.service;

import com.health.dto.UserLoginDTO;
import com.health.entities.User;
import com.health.vo.UserVO;

public interface AdminService {
    User login(UserLoginDTO userLoginDTO);

    UserVO queryById(String id);

    void deleteById(String id);
}
