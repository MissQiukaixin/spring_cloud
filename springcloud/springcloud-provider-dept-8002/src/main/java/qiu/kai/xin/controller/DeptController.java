package qiu.kai.xin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.pojo.Dept;
import qiu.kai.xin.service.DeptService;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService service;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = service.queryById(id);
        return dept;
    }

    @GetMapping("/dept/all")
    public List<Dept> getAll(){
        List<Dept> list = service.queryAll();
        return list;
    }

    @GetMapping("/dept/add")
    public boolean add(Dept dept){
        boolean b = service.addDept(dept);
        return b;
    }

    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    //注册劲来的微服务～，获取一些消息
    @GetMapping("/")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> service = client.getServices();
        System.out.println("discovery=>service"+service);

        //得到一个具体的微服务信息。通过具体的微服务id,application
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT-8001");

        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()+"\t"
            );
        }
        return this.client;
    }
}
