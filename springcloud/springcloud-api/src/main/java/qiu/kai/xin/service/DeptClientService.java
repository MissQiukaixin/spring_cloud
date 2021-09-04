package qiu.kai.xin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import qiu.kai.xin.pojo.Dept;

import java.util.List;

@Component
//                    SPRINGCLOUD-PROVIDER-DEPT
@FeignClient(value = "springcloud-provider-dept",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping("/dept/get/{id}")
    public Dept queryBtId(@PathVariable("id")Long id);

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

    //这个不模拟了
    //public Dept addDept(Dept dept);

}
