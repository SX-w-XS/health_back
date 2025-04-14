package com.health.controller.user;

import com.github.pagehelper.PageInfo;
import com.health.constant.JwtClaimsConstant;
import com.health.context.BaseContext;
import com.health.dto.MessageDTO;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.dto.UserSignUpDTO;
import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageD;
import com.health.entities.Message;
import com.health.entities.User;
import com.health.properties.JwtProperties;
import com.health.result.Result;
import com.health.service.AdminService;
import com.health.service.ChatService;
import com.health.service.UserService;
import com.health.utils.JwtUtil;
import com.health.vo.UserLoginVO;
import com.health.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
@Api(tags = "用户相关接口")
public class UserController {
    @Autowired
    private JwtProperties jwtProperties;

    @Resource
    private UserService userService;

    @Resource
    private AdminService adminService;

    @Resource
    private ChatService chatService;
    @Autowired
    private HttpSession httpSession;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session) {
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
        userLoginVO.setUserId(user.getUserId());
        userLoginVO.setToken(token);
        httpSession.setAttribute("userId",user.getUserId());
        return Result.success(userLoginVO);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户登出")
    public Result<String> logout(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登出：{}", userLoginDTO);
        BaseContext.removeCurrentId();
        return Result.success("登出成功");
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result register(@RequestBody UserSignUpDTO UserSignUpDTO) {
        log.info("用户注册：{}", UserSignUpDTO);
        userService.register(UserSignUpDTO);
        return Result.success("注册成功");
    }


    @PostMapping("/update")
    @ApiOperation(value = "更新用户信息")
    public Result update(@RequestBody UserDTO user) {
        log.info("更新用户信息：{}", user);
        userService.update(user);
        return Result.success("更新成功");
    }

    @PostMapping("/queryMessage")
    @ApiOperation("公告")
    public Result message(@RequestBody MessageDTO messageDTO) {
        log.info("新闻公告");
        return Result.success(adminService.queryMessage(messageDTO));
    }

    @PostMapping("/queryAllMessage")
    @ApiOperation("查询所有公告")
    public Result queryAllMessage(int pageNum, int pageSize,int limit)    {
        log.info("查询所有信息");
        return Result.success(adminService.queryAllMessage(pageNum, pageSize,limit));
    }

    @PostMapping("/queryById")
    @ApiOperation(value = "根据id查询用户信息")
    public Result<UserVO> queryById(String id) {
        log.info("查询用户信息：{}", id);
        if (adminService.queryById(id)==null) {
            return Result.error("用户不存在");
        }
        return Result.success(adminService.queryById(id));
    }

    @PostMapping("/countData")
    @ApiOperation(value = "统计用户数据")
    public Result countData(Integer userID) {
        return Result.success(userService.countData(userID));
    }


}
