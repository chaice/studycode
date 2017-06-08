package com.ccit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/5.
 */
public class ProviderDemo {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:provider.xml");
        applicationContext.start();

        System.in.read();
    }
}
