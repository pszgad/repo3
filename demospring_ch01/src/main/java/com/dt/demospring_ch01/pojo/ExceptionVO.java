package com.dt.demospring_ch01.pojo;

import lombok.Data;

@Data
public class ExceptionVO{

    private  int code;//错误代码编号
    private String  url;//结果
    private  String msg;//信息



    public ExceptionVO(int code, String url, String msg) {
        this.code = code;
        this.url = url;
        this.msg = msg;
    }
}
