package com.service;

import com.fallback.PowerFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SERVER-POWER",fallbackFactory = PowerFallBack.class)
public interface PowerService {
    @RequestMapping("/getPower")
    public Object getPower();
}
