package qiu.kai.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import qiu.kai.myrule.MyRule;

@SpringBootApplication
@EnableEurekaClient
//微服务启动的时候就会去加载自定义的Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class springConsumerRun {
    public static void main(String[] args) {
        SpringApplication.run(springConsumerRun.class,args);
    }
}
