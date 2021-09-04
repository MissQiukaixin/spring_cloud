package qiu.kai.xin.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"qiu.kai.xin.dao"})
public class MyBatisConfig {
}
