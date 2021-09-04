package qiu.kai.xin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;
import qiu.kai.xin.service.PaymentService;
//热部署ctrl + F9

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

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
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******插入结果是:"+payment);

        if (payment != null){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getServerPort(){
        return serverPort;
    }

}
