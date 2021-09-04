package qiu.kai.xin;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;



//@MapperScan(basePackages = "qiu.kai.xin.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker  //添加熔断的支持
/**
 * dashbodard 只监控  @HystrixCommand(fallbackMethod = "hystrixGet")注释下的请求
 * 页面监听的地址：http://localhost:8005/actuator/hystrix.stream
 */

public class DeptProvider_8005 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8005.class, args);
    }

    //增加一个servlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        bean.addUrlMappings("/actuator/hystrix.stream");
        return bean;
    }
}