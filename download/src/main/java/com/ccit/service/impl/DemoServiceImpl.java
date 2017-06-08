package com.ccit.service.impl;

import com.ccit.service.DemoService;

/**
 * Created by Administrator on 2017/6/5.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        System.err.println(name);
        return "Hello"+name;
    }
}
