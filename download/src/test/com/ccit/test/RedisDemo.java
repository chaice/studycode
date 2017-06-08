package com.ccit.test;

import com.ccit.service.TBItemService;
import com.ccit.utils.ClusterUtil;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

/**
 * Created by Administrator on 2017/6/5.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisDemo {
    @Autowired
    private TBItemService itemService;
    @Test
    public void test(){
        itemService.getAll();
    }

}
