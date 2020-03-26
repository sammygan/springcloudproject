package com.polling;

import com.Sequence;
import com.ServerIps;

import java.util.HashMap;
import java.util.Map;

public class PollingAlgorithm2 {
    private static Map<String,Weight> weightMap = new HashMap<>();
    private static Integer pos = 0;
    public static String getIp(){
        boolean sameFlag = true;
        Integer totalWeight = 0;
        Object[] weights = ServerIps.wordMap.values().toArray();
        for(int i=0;i<weights.length;i++){
            totalWeight = totalWeight+(Integer) weights[i];
            if(sameFlag&&i>0&&weights[i]!=weights[i-1]){
                sameFlag = false;
            }
        }
        if(!sameFlag){
            if(weightMap.isEmpty()){
                for (Map.Entry<String,Integer> entry:ServerIps.wordMap.entrySet()){
                    weightMap.put(entry.getKey(),new Weight(entry.getKey(),entry.getValue(),entry.getValue()));
                }
            }
            Weight maxWeight = null;
            for (Weight weight:weightMap.values()
                 ) {
                if(maxWeight==null||maxWeight.getCurrentWeight()<weight.getCurrentWeight()){
                    maxWeight = weight;
                }
            }
            maxWeight.setCurrentWeight(maxWeight.getCurrentWeight()-totalWeight);
            for (Weight weight:weightMap.values()){
                weight.setCurrentWeight(weight.getCurrentWeight()+weight.getWeight());
            }
            weightMap.put(maxWeight.getIp(),maxWeight);
            return maxWeight.getIp();
        }
        String ip = "";
        Object[] words = ServerIps.wordMap.keySet().toArray();
        synchronized (pos){
            if(pos>=words.length){
                pos = 0;
            }
            ip = (String)words[pos++];
        }
        return ip;
    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            System.out.println(getIp());

        }
    }
}
