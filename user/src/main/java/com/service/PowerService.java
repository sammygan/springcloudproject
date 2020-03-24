package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVER-POWER")
public interface PowerService {
    @RequestMapping("/getPower")
    public Object getPower();
}
