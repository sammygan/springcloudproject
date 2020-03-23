package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PowerController {
    @RequestMapping("/getPower")
    public Map<String,Object> getPower(){
        Map<String,Object> map = new HashMap<>();
        map.put("retrunCode","200");
        map.put("retrunMsg","power1");
        return map;
    }
}
