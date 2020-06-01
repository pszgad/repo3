package com.dt.demospring_ch01.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@Data
public class UploadVO  implements Serializable {

    private  int code;//状态码1：成功 -1失败
    private  Object data;//结果
    private  String msg;//信息

    public UploadVO() {
    }
    public UploadVO(int code, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    public UploadVO(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

}
