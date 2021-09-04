package qiu.kai.xin;


import myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
/**
 * 1.添加ribbon 的配置，不能被spring扫描到，要做一个项目的独立配置
 * 2.@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
 */
//指定的消费端  ，配置是自定义的
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
