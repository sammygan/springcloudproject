package com;

import config.OrderRuleConfig;
import config.PowerRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@RibbonClients({
        @RibbonClient(name="SERVER-POWER",configuration = PowerRuleConfig.class),
        @RibbonClient(name="SERVER-ORDER",configuration = OrderRuleConfig.class)
})
@EnableFeignClients
@EnableHystrix
public class AppUser {
    public static void main(String[] args) {
        SpringApplication.run(AppUser.class);
    }
}
