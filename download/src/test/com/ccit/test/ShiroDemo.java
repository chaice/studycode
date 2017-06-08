package com.ccit.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/6.
 */
public class ShiroDemo {
    @Test
    public void test(){
        //获取SecurityManager工厂,使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //得到SecurityManager实例,并绑定SecurityUtils
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        //得到Subject,创建用户名/密码身份验证token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try{
            subject.login(token);
        }catch (Exception e){
            System.err.println("身份验证失败");
        }
        //判断用户是否已经登录
        System.out.println(subject.isAuthenticated());
        //得到一个身份集合,包含了Realm验证成功的身份信息
        System.out.println(subject.getPrincipals());
        //判断拥有的角色
        System.err.println(subject.hasAllRoles(Arrays.asList("admin","user")));
        //判断拥有权限 user:create
        System.out.println(subject.isPermitted("user:create"));
        //判断拥有权限 user:create user:update
        System.out.println(subject.isPermittedAll("user:create","user:update"));
    }
}
