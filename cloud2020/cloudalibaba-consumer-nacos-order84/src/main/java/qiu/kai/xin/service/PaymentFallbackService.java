package qiu.kai.xin.service;

import org.springframework.stereotype.Component;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;


//这个是用来兜底的
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(long id) {
        return new CommonResult<>(444,"服务降级放回，---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
