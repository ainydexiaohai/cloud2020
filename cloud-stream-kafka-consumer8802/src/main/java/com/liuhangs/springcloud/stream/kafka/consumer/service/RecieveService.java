package com.liuhangs.springcloud.stream.kafka.consumer.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@EnableBinding(Sink.class)
@Service
public class RecieveService {

    @StreamListener(Sink.INPUT)
    public void recieve(String payload){
        System.out.println(payload);
    }
}
