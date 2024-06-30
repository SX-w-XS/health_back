package com.health.aspect;

import com.health.annotation.AutoFill;
import com.health.constant.AutoFillConstant;
import com.health.context.BaseContext;
import com.health.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.aspect
 * @Author: X_X
 * @Description: 自定义切面，实现公共字段处理逻辑
 * @Version: 1.0
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    //切入点
    @Pointcut("execution(* com.health.mapper.*.*(..)) && @annotation(com.health.annotation.AutoFill)")
    public void autoFillPointCut(){}
     //前置通知
     @Before("autoFillPointCut()")
    public  void  autoFill(JoinPoint joinPoint){
           log.info("开始进行公共填充");
         //获取拦截的数据困操作类型
         MethodSignature signature = (MethodSignature) joinPoint.getSignature();
         AutoFill annotation = signature.getMethod().getAnnotation(AutoFill.class);
         OperationType operationType=annotation.value();

         //获取拦截参数--实体对象
         Object[] args = joinPoint.getArgs();
         if(args.length==0||args==null){
             return;
         }
         Object entity=args[0];

         //实体对象赋值（根据不同的操作）
         LocalDateTime now=LocalDateTime.now();
         Long id= BaseContext.getCurrentId();

         if(operationType==OperationType.INSERT){
              //四个字段赋值
             try {
                 Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                 Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                 Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                 Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);

                 //通过反射为对象赋值
                  setCreateTime.invoke(entity, now);
                  setCreateUser.invoke(entity,id);
                  setUpdateTime.invoke(entity,now);
                  setUpdateUser.invoke(entity,id);
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }

         } else if (operationType==OperationType.UPDATE) {
              //两个字段
             try {

                 Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);
                 Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);

                 //通过反射为对象赋值
                 setUpdateTime.invoke(entity,now);
                 setUpdateUser.invoke(entity,id);
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }
         }
     }

}
