package com.nahid.simpleboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void listener(CustomMessage message) {
//        System.out.println(message.toString());
//    }
}
