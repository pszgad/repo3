package com.dt.demospring_ch01.pojo;

import lombok.Data;

@Data
public class MyException extends  RuntimeException{

    private  int code;
    private  String url;
    private  String msg;

    public MyException(int code, String url, String msg) {
        this.code = code;
        this.url = url;
        this.msg = msg;
    }
}
