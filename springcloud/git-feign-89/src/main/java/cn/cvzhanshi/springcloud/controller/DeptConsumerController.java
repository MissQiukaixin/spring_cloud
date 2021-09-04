package cn.cvzhanshi.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import qiu.kai.xin.pojo.Dept;
import qiu.kai.xin.service.DeptClientService;

import java.util.List;

/**
 * @author cVzhanshi
 * @create 2021-06-26 17:12
 */
@RestController
public class DeptConsumerController {
    @Autowired
    private DeptClientService deptClientService;

    /**
     * 消费方根据id查询部门信息
     * @param id
     * @return
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryBtId(id);
    }

    /**
     * 消费方查询部门信息列表
     * @return
     */
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.queryAll();
    }

}
