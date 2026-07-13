package algos;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubarray {
    public static void main(String args[]){
        getLongestNonRepeatingSubarrayImprovised("bpfbhmipx");
    }

    private static int getLongestNonRepeatingSubarrayImprovised(String s) {
        int start = 0;
        int bestLength = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(countMap.containsKey(c) && countMap.get(c) >= start){
                start = countMap.get(c) + 1;
            }

            countMap.put(c, i);
            bestLength = bestLength > (i - start + 1) ? bestLength : i - start + 1;
        }
        return bestLength;
    }

    public static int getLongestNonRepeatingSubarray(String s) {
        if(s.equalsIgnoreCase("")){
            return 0;
        }
        int length = 1;
        int j = 0;
        Map<String, Integer> countMap = new HashMap<>();
        while(j < s.length()){
            String substring = s.substring(j, j + 1);
            if(countMap.containsKey(substring)){
                if(countMap.size() > length){
                    length = countMap.size();
                }
                int d = countMap.get(substring);
                while(d >= 0){
                    String substring1 = s.substring(d, d + 1);
                    if (!countMap.containsKey(substring1)) break;
                    if(countMap.get(substring1) == d) {
                        countMap.remove(substring1);
                    }
                    d--;
                }
                countMap.put(substring, j);
            } else {
                countMap.put(substring, j);
                if(j == (s.length()-1)){
                    if(countMap.size() > length){
                        length = countMap.size();
                    }
                }
            }
            j++;
        }
        return length;
    }
}