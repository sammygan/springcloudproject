package com.random;

import com.ServerIps;

import java.util.Random;

public class RandomAlgorithm1 {

    public static String getIp(){
        boolean sameFlag = true;
        Integer totalWeight = 0;
        Object[] weights = ServerIps.ipMap.values().toArray();
        for(int i=0;i<weights.length;i++){
            totalWeight = totalWeight+(Integer) weights[i];
            if(sameFlag&&i>0&&weights[i]!=weights[i-1]){
                sameFlag = false;
            }
        }
        if(!sameFlag){
            Random random = new Random();
            int index = random.nextInt(totalWeight);
            for (String ip:ServerIps.ipMap.keySet()) {
                if(index<ServerIps.ipMap.get(ip)){
                    return ip;
                }
                index = index - ServerIps.ipMap.get(ip);
            }
        }
        Random random = new Random();
        Object[] ips = ServerIps.ipMap.keySet().toArray();
        int index = random.nextInt(ips.length);
        return (String)ips[index];

    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            System.out.println(getIp());
        }
    }
}
