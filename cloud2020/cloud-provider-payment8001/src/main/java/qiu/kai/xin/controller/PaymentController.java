package qiu.kai.xin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;
import qiu.kai.xin.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
//热部署ctrl + F9

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("******插入结果是:"+result);

        if (result > 0){
            return new CommonResult(200,"插入数据库成功"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******插入结果是:"+payment);

        if (payment != null){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> service = discoveryClient.getServices();
        for (String element : service) {
            log.info("*****element"+element);
        }
        // 获取你指定 需要服务的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getServerPort(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    //cloud-consumer-order80 来制定的
    @GetMapping("/payment/zipkin")
    public String paymentZipKin(){
        return "hi , i am paymentZipiKin fall back ,WelCone to qiukaixin, 😄";
    }
}
