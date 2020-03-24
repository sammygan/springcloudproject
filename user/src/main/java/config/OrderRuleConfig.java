package config;

import com.myrule.MyRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRuleConfig {
    @Bean
    public IRule getOrderRule(){
        return new RandomRule();
    }
}
