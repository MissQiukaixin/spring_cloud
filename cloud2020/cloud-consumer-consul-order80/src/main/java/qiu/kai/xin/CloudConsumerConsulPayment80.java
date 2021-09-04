package qiu.kai.xin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerConsulPayment80 {

    public static void main(String[] args) {

        SpringApplication.run(CloudConsumerConsulPayment80.class,args);


    }


}
