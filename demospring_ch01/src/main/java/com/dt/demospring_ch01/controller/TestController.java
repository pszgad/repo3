package com.dt.demospring_ch01.controller;

import com.dt.demospring_ch01.pojo.MyException;
import com.dt.demospring_ch01.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/index.html")
    public  String index(){
   // int a=11/0;//实验异常
     //   System.out.println("---->进入后台");
        System.out.println("--->热部署测试；；；");

        return  "index";
    }
    @GetMapping("/cccc")
    public  String ccc() throws Exception {
        System.out.println(1);
        int i=0;
        if(i==0){
            throw  new MyException(1011,"/cscc","自定义异常");
        }
        return  "index";
    }
}
