package qiu.kai.xin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiu.kai.xin.dao.PaymentDao;
import qiu.kai.xin.entities.Payment;
import qiu.kai.xin.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService
{
//    @Autowired   @Resource  两个都行
    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
