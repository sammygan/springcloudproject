package com.polling;

import com.Sequence;
import com.ServerIps;

public class PollingAlgorithm1 {
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
           Integer num = Sequence.getNum();
           Integer index = num%totalWeight;
           for (String word:ServerIps.wordMap.keySet()){
               if(index<ServerIps.wordMap.get(word)){
                   return word;
               }
               index = index -ServerIps.wordMap.get(word);
           }
       }
        String word = "";
        Object[] words = ServerIps.wordMap.keySet().toArray();
        synchronized (pos){
            if(pos>=words.length){
                pos = 0;
            }
            word = (String)words[pos++];
        }
        return word;
    }

    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            System.out.println(getIp());

        }
    }
}
