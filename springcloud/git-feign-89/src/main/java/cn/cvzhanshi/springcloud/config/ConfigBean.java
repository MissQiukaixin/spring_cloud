package cn.cvzhanshi.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author cVzhanshi
 * @create 2021-06-26 17:13
 */
@Configuration
public class ConfigBean {
    //配置负载均衡实现RestTempLate
    // IRule
    // RoundRobinRule 轮询
    // RandomRule 随机
    // AvailabilityFilteringRule :会先过滤掉，跳闸，访问故障的服务~,对剩下的进行轮诲
    // RetryRule :会先按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
    @LoadBalanced //配置负载均衡实现RestTemplate
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
