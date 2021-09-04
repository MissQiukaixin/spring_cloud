package qiu.kai.xin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderDemoApplication9001 {
    // nacos的group配置在8848网站上的
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderDemoApplication9001.class,args);
    }

    @RestController
    public class EchoController {
        @GetMapping(value = "/echo/{string}")
        public String echo (@PathVariable("string") String string){
            return "Hello Nacos Discovery" + string;
        }


    }
}
