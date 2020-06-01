package com.dt.demospring_ch01.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix = "person")
public class Person {
  @Value("${person.name}")
    private  String name;
    @Value("#{11*2}")
    private  Integer age;
    @Value("true")
    private  Boolean boss;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }



    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getBoss() {
        return boss;
    }
}
