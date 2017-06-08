package com.ccit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.persistence.ParameterMode;

/**
 * Created by Administrator on 2017/6/5.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateTest {
    @Autowired
    private SessionFactory sessionFactory;
    @Test
    public void test(){
       Session session = sessionFactory.openSession();
       ProcedureCall call = session.createStoredProcedureCall("proc_test");
       call.registerParameter(0,Integer.class, ParameterMode.IN).bindValue(1);
       call.registerParameter(1,String.class,ParameterMode.OUT);
       System.err.println(call.getOutputs());
    }
}
