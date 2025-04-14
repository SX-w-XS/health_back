package com.health.utils;


import com.alibaba.fastjson.JSON;
import com.health.result.ResultMessage;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.utils
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
public class MessageUtils {
    public static String getMessage(Boolean flag,Integer userId ,Object message){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setFlag(flag);
        resultMessage.setMessage(message);
        if (userId != null){
            resultMessage.setNickName(userId);
        }
        return JSON.toJSONString(resultMessage);

}}
