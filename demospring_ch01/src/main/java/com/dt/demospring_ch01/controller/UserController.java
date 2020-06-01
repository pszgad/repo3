package com.dt.demospring_ch01.controller;

import com.dt.demospring_ch01.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/aaa")
public class UserController {
    @RequestMapping("/test")
    public  String testController(String name){

        return "hello:"+name;
    }

    @RequestMapping("/test2")
    public  String testController2(User user){

        return "编号:"+user.getUid()+" 姓名："+user.getUname();
    }
    @RequestMapping("/hello")
    public Map< String,Object> showHelloWord(){
       Map<String,Object> map= new HashMap<>();
       map.put("msg","HelloWord");
        return map;
    }
    @RequestMapping("/{uname}/{upwd}")
    public  String testController3(@PathVariable("uname") String name,
                                   @PathVariable("upwd") String pwd){

        return "restful风格,获取值："+name+"密码:"+pwd;
    }
    @GetMapping("/test3")
    public  String testController4(String name){

        return "GET获取:"+name;
    }
    @PostMapping("/test4")
    public  String testController5(String name){

        return "post获取:"+name;
    }

    @GetMapping("/testParam")
    public  String testParam(@RequestParam(defaultValue = "1",name = "currentpage")int currentpage
                          , @RequestParam(defaultValue = "15",name = "pagesize")int pagesize ){

        return "测试分页请求数据:currentpage"+currentpage+"\tpagesize"+pagesize;
    }
    @PostMapping("/testJson")
    public  String testJson(@RequestBody User user){

        return "测试Json数据"+user.getUname();
    }
    @GetMapping("/testToken")
    public  String testToken(@RequestHeader("access_token")String accessToken){

        return "测试令牌："+accessToken;
    }

    @PutMapping("/testPut")
    public  String testPut(User user){

        return "测试put请求："+user.getUname();
    }
    @PutMapping("/testJson2")
    public User testJson2(String name){
            User user=new User();
            user.setUid(11);
            user.setUname("小明");
            user.setUpwd("222");
            user.setBirthday(new Date());
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String s= formatter.format(user.getBirthday());
        System.out.println(s);

     //   System.out.println(user.getUid()+user.getUname());
       // System.out.println(user.toString());
        return user;
    }
    @DeleteMapping("testDelete/{id}")
    public  String testDelete(@PathVariable("id") int id){

        return "测试删除的id："+id;
    }
}
