package com.dt.demospring_ch01.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    //配置拦截器


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //告诉TestIntercetor
        registry.addInterceptor(new TestIntercetor()).addPathPatterns("/test");
        //自定义拦截器需要添加到接口父类中
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
