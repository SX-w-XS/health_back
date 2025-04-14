package com.health.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.result
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage {
    private Object message;
    private Boolean flag;
    private Integer nickName;
}
