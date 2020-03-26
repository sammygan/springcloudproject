package com.random;

import com.ServerIps;

import java.util.Random;

public class RandomAlgorithm {

    public static String getIp(){
        Random random = new Random();
        int index = random.nextInt(ServerIps.ipList.size());
        String ip = ServerIps.ipList.get(index);
        return ip;
    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            System.out.println(getIp());

        }
    }
}
