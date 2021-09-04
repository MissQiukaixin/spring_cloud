package qiu.kai.xin.service.impl;


import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import qiu.kai.xin.dao.OrderDao;
import qiu.kai.xin.domain.Order;
import qiu.kai.xin.service.AccountService;
import qiu.kai.xin.service.OrderService;
import qiu.kai.xin.service.StorageService;



import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp_tx_group",rollbackFor = Exception.class)
    public void create(Order order) {
        //1.创建订单
        log.info("------->开始新建订单");
        orderDao.create(order);

        //2.扣库存
        log.info("------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务开始调用库存，做扣减end");

        //3.扣钱
        log.info("=============测试跟hello的连通性===========");
        accountService.hello();
        log.info("=============可以连通===========");

        log.info("------->订单微服务开始调用账户，做扣减Mony");
        System.out.println("开始报错。。。。。");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->订单微服务开始调用账户，做扣减end");

        //4.修改订单状态，从零到1，1代表已经完成
        log.info("------->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------->修改订单状态结束");


        log.info("------->订单结束了，😄");

    }
}
