package com.lq.springcloud.controller;

import com.lq.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianmeng
 * @date 2020/11/10
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProviderService messageProviderService;

    @GetMapping("/sendMessage")
    public String send() {
        return messageProviderService.send();
    }
}
