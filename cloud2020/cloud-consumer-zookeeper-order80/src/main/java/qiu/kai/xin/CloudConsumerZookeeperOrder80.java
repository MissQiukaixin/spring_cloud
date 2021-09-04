package qiu.kai.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerZookeeperOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerZookeeperOrder80.class,args);
    }
}
