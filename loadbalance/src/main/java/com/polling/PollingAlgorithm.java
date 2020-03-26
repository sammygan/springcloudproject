package com.polling;

import com.ServerIps;

import java.util.Random;

public class PollingAlgorithm {
    private static Integer pos = 0;
    public static String getIp(){
        String ip = "";
        synchronized (pos){
            if(pos>=ServerIps.ipList.size()){
                pos = 0;
            }
            ip = ServerIps.ipList.get(pos++);
        }
        return ip;
    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            System.out.println(getIp());

        }
    }
}
