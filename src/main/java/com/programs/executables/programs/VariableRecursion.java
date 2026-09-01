package com.programs.executables.programs;

import java.util.HashMap;
import java.util.Map;

public class VariableRecursion {
    static void main(String[] args) {
        Map<String, String[]> valueMap = new HashMap<>();
        String[][] arr = new String[][]{{"A", "B", "3"}, {"C", "A", "D", "2"}, {"D", "A", "1"}, {"B", "3"}};
        for(int i = 0; i < arr.length; i++) {
            valueMap.put(arr[i][0], arr[i]);
        }
        Map<String, Integer> sumMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            replace(arr[i], valueMap, sumMap);
        }

        System.out.println(sumMap);
    }

    private static int replace(String[] arr, Map<String, String[]> valueMap, Map<String, Integer> sumMap) {
        if(sumMap.containsKey(arr[0])){
            return sumMap.get(arr[0]);
        }
        int sum = 0;
        for(int i = 1; i < arr.length ; i++){
            if(sumMap.containsKey(arr[i])){
                sum += sumMap.get(arr[i]);
            }
            else if(!isInteger(arr[i])){
                int val = replace(valueMap.get(arr[i]), valueMap, sumMap);
                sum += val;
            }else {
                sum += Integer.parseInt(arr[i]);
            }
        }
        sumMap.put(arr[0], sum);
        return sum;
    }

    public static boolean isInteger(String str) {
        return str != null && str.matches("-?\\d+");
    }
}
