package com.dt.demospring_ch01.config;

import com.dt.demospring_ch01.listener.firstListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean=new ServletListenerRegistrationBean(new firstListener());
        return bean;
    }
}
