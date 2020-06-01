package com.dt.demospring_ch01.exception;

import com.dt.demospring_ch01.pojo.ExceptionVO;
import com.dt.demospring_ch01.pojo.MyException;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConterollerHandler   {

    @ExceptionHandler(value =MyException.class )
    public  Object allException(MyException e){
        System.out.println(e.getCode()+e.getUrl()+e.getMsg());
       // return  0;
      return new ExceptionVO(e.getCode(),e.getUrl(),e.getMsg());
    }


}
