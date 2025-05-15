package com.health.controller.admin;

import com.github.pagehelper.PageInfo;
import com.health.constant.JwtClaimsConstant;
import com.health.context.BaseContext;
import com.health.dto.MessageAddDTO;
import com.health.dto.MessageDTO;
import com.health.dto.UserDTO;
import com.health.dto.UserLoginDTO;
import com.health.entities.DiseaseKnowledge;
import com.health.entities.Review;
import com.health.entities.User;
import com.health.properties.JwtProperties;
import com.health.result.Result;
import com.health.service.AdminService;
import com.health.service.UserService;
import com.health.utils.JwtUtil;
import com.health.vo.UserGrowthVO;
import com.health.vo.UserLoginVO;
import com.health.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.controller.admin
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags = "管理相关接口")
public class AdminController {

    @Autowired
    private JwtProperties jwtProperties;

    @Resource
    private AdminService adminService ;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "管理登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("管理登录：{}", userLoginDTO);
        User admin=adminService.login(userLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.Admin_ID, admin.getUserId());
        String token= JwtUtil.createJWT(jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(admin, userLoginVO);
        userLoginVO.setUserId(admin.getUserId());
        userLoginVO.setToken(token);
        return Result.success(userLoginVO);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "管理登出")
    public Result<String> logout(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("管理登出：{}", userLoginDTO);
        BaseContext.removeCurrentId();
        return Result.success("登出成功");
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

    @PostMapping("/queryUser")
    @ApiOperation(value = "查询用户信息")
    public  Result<PageInfo<UserVO>> queryUser(@RequestBody UserDTO user) {
        log.info("查询用户信息：{}", user);
        if (adminService.queryUser(user)==null) {
            return Result.error("用户不存在");
        }
        return Result.success(adminService.queryUser(user));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户信息")
    public Result update(@RequestBody UserDTO user) {
        log.info("更新用户信息：{}", user);
        userService.update(user);
        return Result.success("更新成功");
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户")
    public Result delete(String id) {
        log.info("删除用户：{}", id);
        adminService.deleteById(id);
        return Result.success("删除成功");
    }

    //批量删除
    @PostMapping("/deleteBatch")
    @ApiOperation(value = "批量删除用户")
    public Result deleteBatch(String[] ids) {
        log.info("批量删除用户：{}", ids);
        adminService.deleteBatch(ids);
        return Result.success("删除成功");
    }

    @PostMapping("/queryAll")
    @ApiOperation(value = "查询所有用户")
    public Result queryAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,@RequestParam("limit") Integer limit)    {
        log.info("查询所有用户");
        return Result.success(adminService.queryAll(pageNum, pageSize,limit));
    }

    @PostMapping("/queryAllMessage")
    @ApiOperation(value = "查询所有信息")
    public Result queryAllMessage(int pageNum, int pageSize,int limit)    {
        log.info("查询所有信息");
        return Result.success(adminService.queryAllMessage(pageNum, pageSize,limit));
    }

    @PostMapping("/queryMessage")
    @ApiOperation(value = "查询信息")
    public Result queryMessage(@RequestBody MessageDTO messageDTO)        {
        log.info("查询信息：{}", messageDTO);
        return Result.success(adminService.queryMessage(messageDTO));
    }

    @PostMapping("/addMessage")
    @ApiOperation(value = "添加公告")
    public Result addMessage(@RequestBody MessageAddDTO messageAddDTO) {
        log.info("添加公告：{}", messageAddDTO);
        adminService.addMessage(messageAddDTO);
        return Result.success("添加成功");
    }

    @PostMapping("/deleteMessage")
    @ApiOperation(value = "删除公告")
    public Result deleteMessage(@RequestParam("ids") List<Integer> ids) {
        log.info("删除公告：{}", ids);
        adminService.deleteMessage(ids);
        return Result.success("删除成功");
    }

    @PostMapping("/getSuggestion")
    @ApiOperation(value = "获取建议")
    public Result getSuggestion(){
        log.info("获取建议");
        return Result.success(adminService.getSuggestion());
    }


    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public Result addUser(@RequestBody UserDTO userAddDTO) {
        log.info("添加用户：{}", userAddDTO);
        adminService.addUser(userAddDTO);
        return Result.success("添加成功");
    }


    //统计接口
    @PostMapping("/queryCount")
    @ApiOperation(value = "统计总用户数")
    public Result queryCount() {
           log.info("统计总用户数");
           return Result.success(adminService.queryCount());
    }


    @PostMapping("/queryPerict")
    @ApiOperation(value = "用户增长预测")
    public Result<Map<String, Object>> getGrowthData(@RequestParam(defaultValue = "30") int pastDays,
                                                     @RequestParam(defaultValue = "7") int futureDays){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(pastDays - 1);

        // 历史数据
        List<UserGrowthVO> history = adminService.getGrowthSeries(startDate, endDate);

        // 预测数据
        List<UserGrowthVO> forecast = adminService.simplePredict(history, futureDays);

        return Result.success(Map.of(
                "history", history,
                "forecast", forecast,
                "currentTotal", !history.isEmpty() ? history.get(history.size()-1).getTotalCount() : 0
        ));
    }

    @PostMapping("/queryCertify")
    @ApiOperation(value = "获取所有审核信息")
    public Result queryCertify() {
        log.info("查询用户提交的审核信息");
        adminService.queryCertify();
        return Result.success(adminService.queryCertify());
    }

    @PostMapping("/handleCertify")
    @ApiOperation(value = "审核信息")
    public Result handleCertify(@RequestBody Review review) {
        log.info("审核用户提交的审核信息");
        adminService.handleCertify(review);
        return Result.success("操作成功");
    }

    @PostMapping("/addKnowledge")
    @ApiOperation(value = "添加科普知识")
    public Result addKnowledge(@RequestBody DiseaseKnowledge knowledge) {
        log.info("添加科普知识: {}", knowledge);
        adminService.addKnowledge(knowledge);
        return Result.success("添加成功");
    }

    @PostMapping("/deleteKnowledge")
    @ApiOperation(value = "删除科普知识")
    public Result deleteKnowledge(int id) {
        adminService.deleteKnowledge(id);
        return Result.success("删除成功");
    }

    @PostMapping("/updateKnowledge")
    @ApiOperation(value = "修改科普知识")
    public Result update(@RequestBody DiseaseKnowledge diseaseKnowledge){
        adminService.updateKnowledge(diseaseKnowledge);
        return Result.success("修改成功");
    }

    @PostMapping("/queryKnowledge")
    @ApiOperation(value = "查询科普知识")
    public Result queryKnowledge() {
        return Result.success(adminService.getKnowledge());
    }
}
