package qiu.kai.xin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@MapperScan(basePackages = "qiu.kai.xin.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker   //添加对§熔断的支持
public class DeptProvider_8004 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8004.class, args);
    }
}
