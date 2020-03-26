package com.hash;

import com.ServerIps;

import java.util.SortedMap;
import java.util.TreeMap;

public class HashAlgorithm {
    private static SortedMap<Integer,String> map = new TreeMap<>();
    private static final Integer VIRTUAL_NODES = 160;
    static{
        for (String ip : ServerIps.ipList){
            for (int i=0;i<VIRTUAL_NODES;i++){
                int hash = getHash(ip+"VN"+i);
                map.put(hash,ip);
            }
        }
    }
    private static String getIp(String client){
        int hash = getHash(client);
        //得到大于该hash值的排好序的map
        SortedMap<Integer, String> subMap = map.tailMap(hash);
        //得到大于该hash值的第一个元素的位置
        Integer nodeIndex = subMap.firstKey();
        //如果不存在大于该hash值的元素，返回根节点第一个元素
        if (nodeIndex == null) {
            nodeIndex = map.firstKey();
        }
        return map.get(nodeIndex);
    }


    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
            hash += hash << 13;
            hash ^= hash >> 7;
            hash += hash << 3;
            hash ^= hash >> 17;
            hash += hash << 5;
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getIp("client" + i));
        }
    }
}
