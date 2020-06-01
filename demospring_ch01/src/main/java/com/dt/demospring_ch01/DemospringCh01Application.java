package com.dt.demospring_ch01;

import com.dt.demospring_ch01.exception.ExceptionConterollerHandler;
import com.dt.demospring_ch01.filter.TestFilter;
import com.dt.demospring_ch01.filter.TestFilter2;
import com.dt.demospring_ch01.listener.firstListener;
import com.dt.demospring_ch01.pojo.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

//@ServletComponentScan(basePackages = "com.dt.*")
@SpringBootApplication
public class DemospringCh01Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DemospringCh01Application.class, args);
    }
    @Bean
      public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        //单个文件 最大值
        factory.setMaxFileSize("1024000KB");//20M
        //设置总上传数据的大小
        factory.setMaxRequestSize("1024000KB");//1G

        return  factory.createMultipartConfig();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // return super.configure(builder);
        return  application.sources(DemospringCh01Application.class);
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(new TestFilter2());
        //过滤器名称
        registration.setName("TestFilter2");
        //拦截路径
        registration.addUrlPatterns("/*");
        //设置顺序
        registration.setOrder(1);
        return registration;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
        //当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
        registration.setFilter(new TestFilter());
        //过滤器名称
        registration.setName("TestFilter");
        //拦截路径
        registration.addUrlPatterns("/*");
        //设置顺序
        registration.setOrder(10);
        return registration;
    }
    @Bean
    public ServletListenerRegistrationBean getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean=new ServletListenerRegistrationBean(new firstListener());
        return bean;
    }
}
