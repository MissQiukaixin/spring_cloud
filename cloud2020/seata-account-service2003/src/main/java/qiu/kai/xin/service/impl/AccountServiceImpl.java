package qiu.kai.xin.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import qiu.kai.xin.dao.AccountDao;
import qiu.kai.xin.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {


    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->storage-service中扣减库存开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒种的线程  出现超时异常
        try{TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e){ e.printStackTrace();}
        accountDao.decrease(userId,money);
        LOGGER.info("------->storage-service中扣减库存结束");
    }
}
