package qiu.kai.xin.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.pojo.Dept;
import qiu.kai.xin.service.DeptService;

import java.util.List;
//作用是服务区熔断机制
@RestController
public class DeptController {

    @Autowired
    DeptService service;

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = service.queryById(id);
        if (dept == null ){
            throw new RuntimeException("id=>"+id+"不存在该用户");
        }
        return dept;
    }

    //备用方法
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+"不存在该用户")
                .setDb_source("数据库中没有这个数据");
    }

}
