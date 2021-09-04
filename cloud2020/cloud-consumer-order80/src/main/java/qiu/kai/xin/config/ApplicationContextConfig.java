package qiu.kai.xin.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

//    不指定负载均衡默认是：轮询机制
    //指定负载均衡时需要 取消@LoadBalanced
    //@LoadBalanced
    @Bean
    public RestTemplate temp()
    {
        return new RestTemplate();
    }
}
