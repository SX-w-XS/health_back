package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {
      /**
       * @description:微信登录
       * @author: X_X
       * @param: [userLoginDTO]
       * @return: com.sky.entity.User
       **/
     User wxLogin(UserLoginDTO userLoginDTO);



}
