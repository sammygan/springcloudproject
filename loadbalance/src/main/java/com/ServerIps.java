package com;

import java.util.*;

public class ServerIps {
    public static final List<String> ipList =  Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10");
    public static final Map<String,Integer> ipMap = new HashMap<>();
    static {
        ipMap.put("192.168.0.1",2);
        ipMap.put("192.168.0.2",8);
        ipMap.put("192.168.0.3",5);
        ipMap.put("192.168.0.4",4);
        ipMap.put("192.168.0.5",1);
        ipMap.put("192.168.0.6",7);
        ipMap.put("192.168.0.7",6);
        ipMap.put("192.168.0.8",6);
        ipMap.put("192.168.0.9",3);
        ipMap.put("192.168.0.10",8);

    }
    public static final Map<String,Integer> wordMap = new HashMap<>();
    static {
        wordMap.put("A",5);
        wordMap.put("B",3);
        wordMap.put("C",2);

    }

}
