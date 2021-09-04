package qiu.kai.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = {"qiu.kai.xin.service"})
//@ComponentScan("qiu.kai.xin")
//微服务启动的时候就会去加载自定义的Ribbon类
public class Feign_springConsumerRun {
    public static void main(String[] args) {
        SpringApplication.run(Feign_springConsumerRun.class,args);
    }
}
