package com.dt.demospring_ch01.listener;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class firstListener implements ServletRequestListener {


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("---->request被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("---->request初始化");
    }
}
