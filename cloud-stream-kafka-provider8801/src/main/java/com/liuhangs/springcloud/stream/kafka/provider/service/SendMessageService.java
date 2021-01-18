package com.liuhangs.springcloud.stream.kafka.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@EnableBinding(Source.class)
@Service
public class SendMessageService {

    @Autowired
    private Source source;

    public String sendMessage() {
        String uuid = UUID.randomUUID().toString();
        source.output().send(MessageBuilder.withPayload(uuid).build());
        return uuid;

    }
}
