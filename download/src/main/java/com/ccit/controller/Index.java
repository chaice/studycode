package com.ccit.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created by Administrator on 2017/6/5.
 */
@Controller
public class Index {
    @Autowired
    private SessionDAO sessionDAO;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam String username,@RequestParam String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            System.err.println("账号密码错误");
        }
        return "redirect:/index";
    }
    @RequestMapping("/index")
    public String index(Model model){
        Collection<Session> sessionCollection = sessionDAO.getActiveSessions();
        model.addAttribute("sessions",sessionCollection);
        model.addAttribute("sessionsCount",sessionCollection.size());
        return "index";
    }
    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
    @RequestMapping("/loginout")
    public String loginout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }
}
