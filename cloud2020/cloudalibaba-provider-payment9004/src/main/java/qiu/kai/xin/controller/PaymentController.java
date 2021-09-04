package qiu.kai.xin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static
    {
        hashMap.put(1L,new Payment(1L,"41174a4312b44c99b054da688c34120e"));
        hashMap.put(2L,new Payment(1L,"c9ec4f620ff44eee90a58fb9ecc45add"));
        hashMap.put(3L,new Payment(1L,"99275e213082445781f44e22a58afe43"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        System.out.println("id是："+id+"数据是："+payment);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,servletPort: "+ serverPort,payment);
        return result;
    }

}