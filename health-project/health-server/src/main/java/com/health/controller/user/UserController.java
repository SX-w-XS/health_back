package com.health.controller.user;

import com.health.constant.JwtClaimsConstant;
import com.health.context.BaseContext;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.dto.UserSignUpDTO;
import com.health.entities.User;
import com.health.properties.JwtProperties;
import com.health.result.Result;
import com.health.service.UserService;
import com.health.utils.JwtUtil;
import com.health.vo.UserLoginVO;
import com.health.vo.UserVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.controller.user
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "员工相关接口")
public class UserController {
    @Autowired
    private JwtProperties jwtProperties;

    @Resource
    UserService userService;

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);
        User user= userService.login(userLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getUserId());
        String token= JwtUtil.createJWT(jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
                );

        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(user, userLoginVO);
        userLoginVO.setToken(token);
        return Result.success(userLoginVO);
    }

    @PostMapping("/logout")
    public Result<String> logout(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登出：{}", userLoginDTO);
        BaseContext.removeCurrentId();
        return Result.success("登出成功");
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserSignUpDTO UserSignUpDTO) {
        log.info("用户注册：{}", UserSignUpDTO);
        userService.register(UserSignUpDTO);
        return Result.success("注册成功");
    }

    @PostMapping("/queryById")
    public Result<UserVO> queryById(String id) {
         log.info("查询用户信息：{}", id);
         if (userService.queryById(id)==null) {
             return Result.error("用户不存在");
         }
        return Result.success(userService.queryById(id));
         }
    @PostMapping("/update")
    public Result update(@RequestBody UserDTO user) {
        log.info("更新用户信息：{}", user);
        userService.update(user);
        return Result.success("更新成功");
    }
}
