package qiu.kai.xin.service;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     */
    public String paymentInfo_Ok(Integer id){
        return "线程池: " + Thread.currentThread().getName()+" paymentinfo_ok,id = "+ id + "\t" + "o(n_n)哈哈～";
     }


     // 设置超时后执行的方法和超时的时间
    //超时时间的写法是固定的，value是超时时间可以更改
     @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
     @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName()+" id = "+ id + "\t" + "o(n_n)哈哈～"+ "耗时"+ timeNumber+"秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池: " + Thread.currentThread().getName()+" 8001系统繁忙活着运行报错，请稍后再试,id = "+ id + "\t" + "😭哭了";
    }


    /**
     * 做服务器熔断的
     * HystrixCommandProperties  配置断路属性全在这
     *
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled" ,value = "true"),// 是否幵宕晰路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" ,value = "10"),// 清求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" ,value = "1000"), //时间同窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" ,value = "60"),// 失敗率込到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t" + "调用成功，流水号"+ serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("ia")Integer id){
        return "id 不能为负数，请稍后再试😭~ id: "+ id;
    }
}
