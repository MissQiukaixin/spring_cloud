package qiu.kai.xin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

//nacos自带ribbon
//@RestController
//@Slf4j
//public class OrderPaymentController {
//
//    @Resource
//    private RestTemplate restTemplate;
//
//    @Value("${service-url.nacos-user-service}")
//    private String serverURL;
//
//    @GetMapping(value = "/consumer/payment/nacos/{id}")
//    public String get (@PathVariable("id") Long id){
//        System.out.println(serverURL);
//        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
//    }
//
//}