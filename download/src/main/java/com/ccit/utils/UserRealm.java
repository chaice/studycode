package com.ccit.utils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/6.
 */
public class UserRealm extends AuthorizingRealm {
    //根据用户名得到用户的角色
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String username = (String) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> strings = new HashSet<String>();
        strings.add("admin");
        authorizationInfo.setRoles(strings);
        return authorizationInfo;
    }
    //验证用户名和密码是否正确
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "tom","123",getName()
        );
        return authenticationInfo;
    }
}
