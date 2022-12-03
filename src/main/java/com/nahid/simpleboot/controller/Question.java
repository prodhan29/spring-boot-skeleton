package com.nahid.simpleboot.controller;
import com.nahid.simpleboot.rabbitmq.CustomMessage;
import com.nahid.simpleboot.rabbitmq.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class Question {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/info")
    public ResponseEntity<List> getTest() throws Exception {

        CustomMessage message = new CustomMessage();
        message.setMessage("hello world, time is "+ (new Date()).toString() );

        rabbitTemplate.convertAndSend(RabbitMQConfig.exchange, RabbitMQConfig.BINDING_KEY, message);

        System.out.println("Message sent to all consumers ");
        return ResponseEntity.ok(Arrays.asList("one", "two"));
    }

    @GetMapping("/about")
    public ResponseEntity<List> getAbout(){
        List<String> names = Arrays.asList("simple", "spring boot");
        return new ResponseEntity<>(names, HttpStatus.OK);
    }
}
