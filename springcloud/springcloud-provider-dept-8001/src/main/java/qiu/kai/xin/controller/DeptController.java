package qiu.kai.xin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.pojo.Dept;
import qiu.kai.xin.service.DeptClientService;
import qiu.kai.xin.service.DeptService;
import qiu.kai.xin.service.impl.DeptServiceImpl;

import java.util.ArrayList;
import java.util.List;


@RestController
public class DeptController implements DeptClientService {

    @Autowired
    DeptService service;

    @Override
    public Dept queryBtId(Long id) {
        Dept dept = service.queryById(id);
        return dept;
    }

    @Override
    public List<Dept> queryAll() {
        List<Dept> list = service.queryAll();
        return list;
    }
}
