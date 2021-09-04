package qiu.kai.xin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import qiu.kai.xin.pojo.Dept;

import java.util.List;

@RestController
public class DeptConsumerController {

    //理解：消费者，不应该有service层～

    //说白了就是让一个中介
    @Autowired
    private RestTemplate restTemplate;

    private static final  String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";   //可以的

    @RequestMapping("/consumer/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @GetMapping("/consumer/getAll")
    public List<Dept> getAllDept(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/all",List.class);
    }

    @GetMapping("/hello/80")
    public String Hello80(){
        return "hello80";
    }
}
