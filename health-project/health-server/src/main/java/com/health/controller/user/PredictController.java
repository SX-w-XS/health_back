package com.health.controller.user;

import com.health.context.BaseContext;
import com.health.dto.UserLoginDTO;
import com.health.dto.UserPredictDTO;
import com.health.result.Result;
import com.health.service.PredictService;
import com.health.vo.PredictVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.controller.user
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user/predict")
@Slf4j
@Api(tags = "用户预测相关接口")
public class PredictController {

    @Resource
    PredictService predictService;

    @PostMapping("/CVD")
    @ApiOperation(value = "心血管疾病")
    public Result<PredictVO> predictCVD(@RequestBody UserPredictDTO userPredictDTO) {
        log.info("心血管疾病：{}", userPredictDTO);
        PredictVO predict = predictService.predict(userPredictDTO);
        return Result.success(predict);
    }
}
