package com.bigfamily.activemqdemo.controller;

import com.bigfamily.activemqdemo.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
public class DemoController {

    @Autowired
    private Producer producer;

    @GetMapping("/message")
    public void send() {

        Destination destination = new ActiveMQQueue("mytest.queue");

        for(int i=0; i<10; i++){
            producer.sendMessage(destination, "new message!!!");
        }

    }
}
