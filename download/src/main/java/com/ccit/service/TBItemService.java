package com.ccit.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
@Service
@Transactional
public class TBItemService {
    @Autowired
    private SessionFactory sessionFactory;

    public List getAll(){
        Session session = null;
        List salesList = null;
        try{
            session = sessionFactory.openSession();
            String sql = "select year," +
                    "sum(case when season='1' then sale else 0 end) as 第一节度,"
                    +"sum(case when season='2' then sale else 0 end) as 第二节度,"
                    +"sum(case when season='3' then sale else 0 end) as 第三节度,"
                    +"sum(case when season='4' then sale else 0 end) as 第四节度 "
                    +" from sales group by year";
            salesList = session.createSQLQuery(sql).list();
            System.out.println(salesList.get(1).toString());
        }catch (Exception e){

        }finally {
            if(session != null){
                session.flush();
                session.close();
            }
        }
        return salesList;
    }
}
