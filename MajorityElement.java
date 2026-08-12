package programs;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String args[]){
        int[] arr = new int[]{1, 1, 2, 1, 3, 5, 1};
//        int[] arr = new int[]{7};
//        int[] arr = new int[]{2, 13};
        System.out.println(getMojorityElement(arr));
    }

    private static int getMojorityElement(int[] arr) {
        int threshold = arr.length%2 == 0 ? arr.length/2 : (arr.length-1)/2;
        Map<Integer, Integer> countMap = new HashMap<>();
        int highestFreq = 1;
        int highestFreqValue;
        for(int i=0; i < arr.length; i++){
            int count = countMap.getOrDefault(arr[i], 0);
            countMap.put(arr[i], count+1);
            if(count+1 >= highestFreq){
                highestFreq = count+1;
                highestFreqValue = arr[i];
                if(highestFreq > threshold){
                    return highestFreqValue;
                }
            }
        }
        return -1;
    }
}
