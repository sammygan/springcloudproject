package config;

import com.myrule.MyRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PowerRuleConfig {
    @Bean
    public IRule getPowerRule(){
        return new MyRule();
    }
}
