package com.sky.controller.user;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.UserService;
import com.sky.utils.JwtUtil;
import com.sky.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.controller.user
 * @Author: X_X
 * @Description: 微信端
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user/user")
@Slf4j
@Api("用户相关接口")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    JwtProperties jwtProperties;
    /**
     * @description: 微信登录
     * @author: X_X
     * @param: [userLoginDTO]
     * @return: com.sky.result.Result<com.sky.dto.UserLoginDTO>
     **/
    @PostMapping("/login")
    @ApiOperation("微信登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("微信登录：{}", userLoginDTO.getCode());
        // 调用service 方法
        User user = userService.wxLogin(userLoginDTO);
        //生成jwt令牌
        Map<String,Object> claim=new HashMap<>();
        claim.put(JwtClaimsConstant.USER_ID,user.getId());
        String jwt = JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claim);

        //封装DTO对象
        UserLoginVO build = UserLoginVO.builder()
                .id(user.getId())
                .token(jwt)
                .openid(user.getOpenid()).build();
        return  Result.success(build);
    }


}
