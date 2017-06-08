package com.ccit.servlet;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/4/21.
 */
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(123);
           String agent = req.getHeader("User-Agent");
           String filename = "../热点退服.xlxs";
           if(agent.indexOf("MSIE") >0 || agent.indexOf("rv:11") > 1){
               System.out.println("IE 浏览器");
           }else if(agent.indexOf("Chrome") >0){
               filename = new String(filename.getBytes("UTF-8"),"ISO8859-1");
           }else if(agent.indexOf("Firefox") >0){
//               filename = new String(filename.getBytes("UTF-8"),"ISO8859-1");
           }
           PrintWriter printWriter = resp.getWriter();
           printWriter.write(filename);
    }
}
