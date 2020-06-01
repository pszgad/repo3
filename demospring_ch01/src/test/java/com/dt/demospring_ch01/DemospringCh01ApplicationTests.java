package com.dt.demospring_ch01;


import com.dt.demospring_ch01.pojo.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemospringCh01Application.class})
@AutoConfigureMockMvc     //测试后台接口(@RequestMapping)配置文件
public class DemospringCh01ApplicationTests {
    @Autowired
    Person person;
    @Test
  public   void contextLoads() {

        System.out.println(person);
        System.out.println("----->测试项目启动成功");
    }

   @Before
   public void beforeTest() {
        System.out.println("----->项目启动之前调用");
        int i=12;
        i++;
       System.out.println("i的值"+i);
    }
    @Autowired
    private MockMvc mockMvc;
    @Test
    public  void apiTest()throws  Exception{
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/index.html")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int a=result.getResponse().getStatus();
        System.out.println("----->测试api接口："+a);
        System.out.println("----->"+result.getResponse());
    }
}
