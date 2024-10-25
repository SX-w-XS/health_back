package com.health.controller.common;

import com.health.exception.ImgErrorException;
import com.health.result.Result;
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
    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public Result<String> upload(MultipartFile file ,HttpServletRequest request)  {
          log.info("文件上传:{}",file);
        String name= file.getName();
        System.out.println(name);
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);

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
            BufferedOutputStream out =new BufferedOutputStream(new FileOutputStream(upload.getAbsoluteFile()
            +"/"+ UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."))));
            byte[] bytes = new byte[1024 * 100];
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
        return  Result.success("上传成功");
    }
}
