package com.health.controller.common;

import com.health.exception.ImgErrorException;
import com.health.result.Result;
import com.health.service.AdminService;
import com.health.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.health.controller.common
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/common")
@Slf4j
@Api(tags = "通用接口")
public class CommonController {
    private final UserService userService;
    private final AdminService adminService;

    public CommonController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public Result<String> upload(MultipartFile file ,HttpServletRequest request)  {
          log.info("文件上传:{}",file);
        String name= file.getName();
        System.out.println(name);
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String FILE;;
        try {
            InputStream in=file.getInputStream();
            BufferedInputStream bis=new BufferedInputStream(in);
            File path=new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()){
                 path=new File("");
            }
            File upload= new File(path.getAbsolutePath(),"/upload/");
            if (!upload.exists()) {
                upload.mkdirs();
            }
            // 将文件写入到指定路径
            String filename=upload.getAbsoluteFile()
                    +"/"+ UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
            FILE = filename;
            BufferedOutputStream out =new BufferedOutputStream(new FileOutputStream(filename));
            byte[] bytes = new byte[1024 * 400];  //增大文件大小
            int readCount = 0;
            while((readCount = in.read(bytes)) != -1){
                out.write(bytes,0,readCount);
            }
            // 刷新缓冲流
            out.flush();
            // 关闭流
            in.close();
            out.close();
        } catch (IOException e) {
            throw new ImgErrorException("图片上传失败");
        }
        return  Result.success(FILE);
    }

    @PostMapping("/saveAvatar")
    @ApiOperation(value = "存储头像路径")
    public Result<String> saveAvtorPath(String filePath, Integer userId) {
        log.info("保存头像图片路径:{}",filePath);
        userService.saveAvtorPath(filePath,userId);
        return Result.success("头像修改成功");
    }

    @PostMapping("/saveApply")
    @ApiOperation(value = "存储申请材料路径")
    public Result<String> saveApplyPath(String filePath, Integer userId) {
        log.info("保存申请图片路径:{}",filePath);
        userService.saveApplyPath(filePath,userId);
        return Result.success("");
    }

    @PostMapping("/saveMedicalImg")
    @ApiOperation(value = "存储药物图片路径")
    public Result<String> saveMedicalImg(String filePath, String medicalName) {
        log.info("保存药物图片路径:{}",filePath);
        adminService.updateMedicine(filePath,medicalName);
        return Result.success("");
    }
}
