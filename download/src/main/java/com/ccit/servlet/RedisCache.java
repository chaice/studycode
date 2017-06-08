package com.ccit.servlet;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/6/2.
 */
public class RedisCache implements MethodInterceptor {

    @Autowired
    private RedisTemplate<Serializable,Object> redisTemplate;

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //获得类名
        String className = methodInvocation.getThis().getClass().getName();
        //获得方法名
        String methodName = methodInvocation.getMethod().getName();
        //获得方法参数
        Object[] params = methodInvocation.getArguments();
        //获得key
        final String keyName = createKey(className,methodName,params);
        Object value = null;
        try{
            if(redisTemplate.hasKey(keyName)){
                value = redisTemplate.opsForValue().get(keyName);
            }else{
                value = methodInvocation.proceed();
                final String tKey = keyName;
                final Object tValue = value;
                new Thread(){
                    @Override
                    public void run() {
                        redisTemplate.opsForValue().set(tKey,tValue);
                        redisTemplate.expire(tKey,1000, TimeUnit.SECONDS);
                    }
                }.start();
            }
        }catch (Exception e) {
            value = methodInvocation.proceed();
            e.printStackTrace();
        }
        return value;
    }

    private String createKey(String className,String methodName,Object[] params){
        StringBuffer keyName = new StringBuffer();
        keyName.append(className).append("_").append(methodName);
        for (int i = 0; i < params.length; i++) {
            keyName.append("_").append(params[i]);
        }
        return keyName.toString();
    }
}
