package qiu.kai.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 把包放在外面防止自动扫描包
@Configuration
public class MyRule {
    @Bean
    public IRule myIRule(){
        return new MyRandomRule();
    }
}
