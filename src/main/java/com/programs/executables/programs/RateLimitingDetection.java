package com.programs.executables.programs;

import java.util.HashMap;
import java.util.Map;

public class RateLimitingDetection {
    static void main(String[] args) {
        String[] input = new String[]{"A", "A", "B", "C", "C", "C", "A", "A", "A", "A", "M","M","M", "J","J","M","M","M","M"};
//        String[] input = new String[]{"A","A", "B", "C", "C" , "C", "A", "A", "A", "A", "B", "B"};
        int threshold = 2;
        Map<String, Integer> countMap = new HashMap<>();
        int count = 1;
        String reqId = input[0];
        for(int i = 1 ; i < input.length; i++){
            if(reqId.equals(input[i])){
                count++;
            } else {
                count = 1;
            }
            if(count > threshold && count < threshold + 2){
                int occurrences = countMap.getOrDefault(input[i], 0);
                countMap.put(input[i], occurrences+1);
            }
            reqId = input[i];
        }
        System.out.println(countMap);

    }
}
