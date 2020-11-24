package com.lq.springcloud.service.impl;

import com.lq.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author tianmeng
 * @date 2020/11/10
 */
@EnableBinding(Source.class)       // 定义消息的推送管道
public class MessageProviderServiceImpl implements IMessageProviderService {

    @Autowired
    private MessageChannel output;  // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString().replace("-", "");
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial: " + serial);
        return serial;
    }
}
