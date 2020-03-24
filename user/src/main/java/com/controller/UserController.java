package com.controller;

import com.service.OrderService;
import com.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    public static String POWER_URL="http://SERVER-POWER";
    public static String ORDER_URL="http://SERVER-ORDER";
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderService orderService;
    @Autowired
    PowerService powerService;
    @RequestMapping(value = "/getUser",produces = { "application/json;charset=UTF-8" })
    public Map<String,Object> getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("returnCode","200");
        return map;
    }
    @RequestMapping("/getPower")
    public Map<String,Object> getPower(){
        Map<String,Object> map = new HashMap<>();
        map.put("returnCode","200");
        map.put("returnMsg","返回成功");
        map.put("data",restTemplate.getForObject(POWER_URL+"/getPower",Object.class));
        return map;
    }
    @RequestMapping("/getOrder")
    public Map<String,Object> getOrder(){
        Map<String,Object> map = new HashMap<>();
        map.put("returnCode","200");
        map.put("returnMsg","返回成功");
        map.put("data",restTemplate.getForObject(ORDER_URL+"/getOrder",Object.class));
        return map;
    }
    @RequestMapping("/feignGetPower")
    public Map<String,Object> feignGetPower(){
        Map<String,Object> map = new HashMap<>();
        map.put("returnCode","200");
        map.put("returnMsg","返回成功");
        map.put("data",powerService.getPower());
        return map;
    }
    @RequestMapping("/feignGetOrder")
    public Map<String,Object> feignGetOrder(){
        Map<String,Object> map = new HashMap<>();
        map.put("returnCode","200");
        map.put("returnMsg","返回成功");
        map.put("data",orderService.getOrder());
        return map;
    }
}
