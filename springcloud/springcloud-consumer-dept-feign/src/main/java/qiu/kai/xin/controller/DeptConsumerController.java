package qiu.kai.xin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import qiu.kai.xin.pojo.Dept;
import qiu.kai.xin.service.DeptClientService;

import java.util.List;

@RestController
public class DeptConsumerController {

    //理解：消费者，不应该有service层～
    @Autowired
    //视频里赋值为null
    //private DeptClientService service = null;
    private DeptClientService service ;

    @RequestMapping("/consumer/get/{id}")
    public Dept get(@PathVariable("id") Long id){
       return this.service.queryBtId(id);
    }

    @GetMapping("/consumer/getAll")
    public List<Dept> getAllDept(){
        return service.queryAll();
    }

    @GetMapping("/hello/80")
    public String Hello80(){
        return "hello80";
    }
}
