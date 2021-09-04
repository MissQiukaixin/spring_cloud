package qiu.kai.xin.service;

import org.apache.ibatis.annotations.Param;
import qiu.kai.xin.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
