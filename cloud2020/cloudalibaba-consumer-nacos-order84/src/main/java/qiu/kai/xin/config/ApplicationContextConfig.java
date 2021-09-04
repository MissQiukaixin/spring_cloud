package qiu.kai.xin.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
//    没写 LoadBalanced   加这个可以自动的配置负载均衡 已免在有两个服务的时候报错
//    java.net.UnknownHostException: nacos-payment-provider
//org.springframework.web.client.ResourceAccessException:
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
