package qiu.kai.xin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.service.IMessageProvider;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sensMessage")
    public String sendMessage(){
        return messageProvider.send();
    }


}
