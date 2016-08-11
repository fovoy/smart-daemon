package com.fovoy.daemon.common.mq.tcp;

import com.aliyun.openservices.ons.api.*;

import java.util.Properties;

/**
 * Created by zxz.zhang on 16/8/11.
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "CID_fovoy_order");
        properties.put(PropertyKeyConst.AccessKey, "jjNcuJyJx4UXhZ7t");
        properties.put(PropertyKeyConst.SecretKey, "NrLe039pFjinGHvDK48PC8W5dqc0Qx");
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("sendorder", "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }
}

