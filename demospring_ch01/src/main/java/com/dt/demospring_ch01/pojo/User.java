package com.dt.demospring_ch01.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private  int uid;
    @JsonInclude(JsonInclude.Include.NON_NULL)//空字段不返回
    @JsonProperty("xxx")
    private  String uname;
    @JsonIgnore//敏感属性不返回
    private  String upwd;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date birthday;

}
