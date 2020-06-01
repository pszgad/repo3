package com.dt.demospring_ch01.controller;

import com.dt.demospring_ch01.pojo.UploadVO;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;
@PropertySource("classpath:application.properties")
@Controller
public class FileController {
   /* @Value("&{web.images-path}")
   private  static   String filepath;*/
   private  static final   String filepath="C:\\Users\\Administrator\\Desktop\\";
   @PostMapping(value = "upload")
   @ResponseBody
    private UploadVO upload(@RequestParam("head_img")MultipartFile file,HttpServletRequest request){
            String name=request.getParameter("name");
        System.out.println("--->接收的用户名："+name);
        //获取文件名
        String fileName=file.getOriginalFilename();
        System.out.println("-->上传文件名为："+fileName);
        //获取文件后缀名
        String suffixName=fileName.substring(fileName.lastIndexOf("."));
        System.out.println("---->上传的后缀名："+suffixName);

       fileName= UUID.randomUUID()+suffixName;
       System.out.println("-->转换后的名称："+fileName);
       //文件上传后的路径
       File dest=new File(filepath+fileName);
       try {
           //文件传输
           file.transferTo(dest);
           return  new UploadVO(1,fileName);
       }catch (Exception e){
                e.printStackTrace();
       }
       return  new UploadVO(-1,"fail to save");
    }
    @GetMapping("/upload")
    public  String upload(){

       return  "upload";
    }

}
