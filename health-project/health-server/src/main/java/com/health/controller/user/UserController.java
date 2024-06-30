package com.health.controller.user;

import com.health.dto.UserLoginDTO;
import com.health.properties.JwtProperties;
import com.health.result.Result;
import com.health.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.controller.user
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        return Result.success();
    }

}
