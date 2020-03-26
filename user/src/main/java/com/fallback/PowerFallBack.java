package com.fallback;

import com.service.PowerService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PowerFallBack implements FallbackFactory<PowerService> {


    @Override
    public PowerService create(Throwable throwable) {
        return new PowerService() {
            @Override
            public Object getPower() {
                System.out.println("我是异常:"+throwable.getMessage());
                return "我是友好的feign";
            }
        };
    }
}
