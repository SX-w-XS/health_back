package com.health.service;

import com.health.dto.UserPredictDMDTO;
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
    //心血管
    public PredictVO predict(UserPredictDTO predictDTO);

    //糖尿病
   PredictVO predictDM(UserPredictDMDTO predictDMDTO);
}
