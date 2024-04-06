package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.controller.admin
 * @Author: X_X
 * @Description: 通用接口
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags = "通用接口")
public class CommonController {
   @Autowired
    private AliOssUtil aliOssUtil;

     /**
      * @description: 文件上传
      * @author: X_X
      * @param: [file]
      * @return: com.sky.result.Result<java.lang.String>
      **/
     @PostMapping("/upload")
     @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){
         log.info("文件上传：{}",file);
         //原始文件名
         String originalFilename = file.getOriginalFilename();
         //截取文件后缀
         String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
         //构建文件名称
         String FileName = UUID.randomUUID().toString() + extension;

         //  String filePath = aliOssUtil.upload(file.getBytes(), FileName);
         return  Result.success(FileName);
     }

}
