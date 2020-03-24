package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVER-ORDER")
public interface OrderService {
    @RequestMapping("/getOrder")
    public Object getOrder();
}
