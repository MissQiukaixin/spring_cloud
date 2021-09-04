package qiu.kai.xin.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;

// 是和 9003一样的配置
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService
{
    //这个接口的访问地址要和9003的一样
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") long id);
}
