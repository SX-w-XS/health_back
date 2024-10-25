package com.health.service;

import com.health.dto.UserPredictDTO;
import com.health.vo.PredictVO;

import java.util.Map;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.service
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
public interface PredictService {
    public PredictVO predict(UserPredictDTO predictDTO);
}
