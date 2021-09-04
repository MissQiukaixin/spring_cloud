package qiu.kai.xin.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qiu.kai.xin.domain.CommonResult;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")   //storage注入到微服务的名称
public interface AccountService
{
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal count);

    @GetMapping("hello")  //测试连通性
    public String hello();
}
