package com.ccit.test;

import com.ccit.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/6/5.
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:consumer.xml");
        applicationContext.start();
        DemoService demoService = (DemoService) applicationContext.getBean("demoService");
        System.out.println(demoService.sayHello("tom"));
    }
}
