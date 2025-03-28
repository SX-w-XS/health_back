package com.health.service;

import com.health.dto.SuggestionDTO;
import com.health.dto.UserPredictDMDTO;
import com.health.dto.UserPredictDTO;
import com.health.vo.HealthAdviceF;
import com.health.vo.HealthAdviceVO;
import com.health.vo.PredictDMVO;
import com.health.vo.PredictVO;

import java.util.List;
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
   PredictDMVO predictDM(UserPredictDMDTO predictDMDTO);

   //综合建议
   HealthAdviceF generateAdvice(SuggestionDTO suggestionDTO);
}
