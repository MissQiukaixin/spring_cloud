package qiu.kai.xin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import qiu.kai.xin.entities.Payment;


@Mapper
public interface PaymentDao
{

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
