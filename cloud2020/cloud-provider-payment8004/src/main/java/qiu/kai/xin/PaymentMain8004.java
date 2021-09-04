package qiu.kai.xin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient   //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8004 {

    public static void main(String[] args) {

        //如果爆的是启动类出问题一般是 zookeeper的版本出了问题
        SpringApplication.run(PaymentMain8004.class,args);






    }

}
