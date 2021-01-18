package com.liuhangs.springcloud.stream.kafka.provider.contorller;

import com.liuhangs.springcloud.stream.kafka.provider.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream/kafka/provider")
public class SendMessageController {

    @Autowired
    private SendMessageService sendMessageService;

    @GetMapping("/send")
    public String sendMessage() {
        return sendMessageService.sendMessage();
    }
}
