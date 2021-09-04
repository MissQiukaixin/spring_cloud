package qiu.kai.xin.service.impl;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import qiu.kai.xin.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;


//不需要注解Service
//使用Stream连接
@EnableBinding(Source.class)   //source和Sink是一对的通信
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;   //  消息发送  搭建通道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());  //发送
        System.out.println("*****serial"+serial);
        return null;
    }
}
