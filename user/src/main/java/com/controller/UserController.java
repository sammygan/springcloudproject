package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    public static String POWER_URL="http://SERVER-POWER";
    @Autowired
    RestTemplate restTemplate;
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
}
