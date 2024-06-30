package com.health.annotation;

import com.health.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 自定义注解
 * @author: X_X
 * @param:
 * @return: 
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    //设置公共字段 : UPDATE INSERT
    OperationType value();
}
