package qiu.kai.xin.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qiu.kai.xin.domain.CommonResult;

@FeignClient(value = "seata-storage-service")   //storage注入到微服务的名称
public interface StorageService
{
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId,@RequestParam("count") Integer count);
}
