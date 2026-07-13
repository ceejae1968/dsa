package algos;

import java.util.*;

/**
 * Rules:
 * Swap two values(i, i+1) any no of times.
 * Once swapped cannot be swapped again.
 * To Do :
 * Calculate Strength of Array
 */
public class SwapStrategy {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(3);

        optimalSwaps(arr);
        calculateStrength(arr);
    }

    public static void optimalSwaps(List<Integer> arr){
        Set<Integer> swappedIndexes = new HashSet<>();
        for(int i = 0; i < arr.size()-1; i++){
            Integer a = arr.get(i);
            Integer a1 = arr.get(i+1);
            Integer a2 = (i+2) > arr.size()-1 ? null : arr.get(i+2);
            if(a1 >= a){
                continue;
            } else {
                if(Objects.nonNull(a2) && (a1-a2) >= (a-a1)){
                    continue;
                } else {
                    if(!(swappedIndexes.contains(i) || swappedIndexes.contains(i+1))) {
                        arr.remove(i);
                        arr.remove(i);
                        arr.add(i, a1);
                        arr.add(i + 1, a);
                        swappedIndexes.add(i);
                        swappedIndexes.add(i + 1);
                    }
                }
            }
        }
    }

    public static long calculateStrength(List<Integer> arr){
        long strength = 0;
        for(int i = 0; i < arr.size(); i++){
            Integer item = arr.get(i);
            strength += item * (i+1);
        }
        System.out.println("Strength -> " + strength);
        return strength;
    }
}
