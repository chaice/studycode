package com.ccit.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2017/4/21.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JsonTest {
    @Autowired
    @Qualifier("jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Test
    public void send(){
        for (int i = 0; i < 5; i++) {
            sendMessage(null,"测试消息!"+i);
        }
    }
    @Test
    public void get(){
        getMessage(jmsTemplate.getDefaultDestination());
    }

    private void getMessage(Destination destination){
       TextMessage message = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.printf("从队列 %s 接收到了消息 %s",
                    destination.toString(),message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(Destination destination , final String message){
        if(destination == null){
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(javax.jms.Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
        System.out.println("send message");
    }
}
