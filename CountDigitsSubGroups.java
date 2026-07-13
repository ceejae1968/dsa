package algos;

import java.util.*;

public class CountDigitsSubGroups {

    public static void main(String[] args){
        String str = "123456";
        int[] stringArray = str.chars()       // IntStream of ASCII values
                .map(c -> c - '0') // Map ASCII to actual digit
                .toArray();
        List<int[]>  subArraysList = new ArrayList<>();
        List<List<int[]>>  rowWiseList = new ArrayList<>();
        for(int  i = 0; i < stringArray.length; i++){
            for(int j = i+1; j <= stringArray.length; j++){
                if(i == 0 && j == stringArray.length){
                    continue;
                }
                subArraysList.add(Arrays.copyOfRange(stringArray, i,j));
            }
            rowWiseList.add(subArraysList);
            subArraysList = new ArrayList<>();
        }
        solve(rowWiseList);
    }

    private static void solve(List<List<int[]>> rowWiseList) {
        Map<Double,String> combinations = new HashMap<>();
        double totalCombinations = Math.pow(2,(rowWiseList.size()-1)) - 1;
        int maxSubarraySize = rowWiseList.size() - 1;
        Map<Integer, Double> gapList = new HashMap<>();
        for(int i = 0; i < rowWiseList.size(); i++){
            gapList.put(i, Math.pow(2, maxSubarraySize-i));
        }
        int pow = maxSubarraySize - 1;
        for(int j = maxSubarraySize; j >= 0; j--) {
            int val = rowWiseList.get(j).size();
            double gap = gapList.get(j);
            int ithIndex = 0;
            for(double i = 0; i < totalCombinations ; i = i + gap){
                if(ithIndex == val){
                    ithIndex = 0;
                    continue;
                }
                double k = i;
                while(ithIndex < val) {
                    StringBuffer str = new StringBuffer(combinations.getOrDefault(i, ""));
                    str.append(rowWiseList.get(j).get(ithIndex));
                    combinations.put(k, str.toString());
                    ithIndex++;
                    k++;
                }

            }
        }
    }


    public static void main2(String[] args){
        String str = "123456";
        int[] stringArray = str.chars()       // IntStream of ASCII values
                .map(c -> c - '0') // Map ASCII to actual digit
                .toArray();
        Set<String> groupList = new HashSet<>();
        for(int size = 2; size < stringArray.length-1; size++) {
            for(int lockIndex = 0; lockIndex < stringArray.length-size; lockIndex++){
                Set<String> objectList = groupCreator(stringArray, size, lockIndex);
                groupList.addAll(objectList);
            }
        }
    }

    private static Set<String> groupCreator(int[] stringArray, int size, int startLockIndex) {
        Set<String> subStringSet = new HashSet<>();
        int endLockIndex = startLockIndex + size - 1;
        StringBuffer subString = new StringBuffer();
        for(int strArrIndex = 0; strArrIndex < stringArray.length; strArrIndex++){
            if (strArrIndex < startLockIndex || strArrIndex > endLockIndex) {
                subString.append(stringArray[strArrIndex]);
                if(size == subString.length()){
                    subStringSet.add(subString.toString());
                    subString = new StringBuffer();
                }
            } else {
                for (int i = 1; i <= size; i++) {
                    subString.append(stringArray[strArrIndex]);
                }
                subStringSet.add(subString.toString());
                subString = new StringBuffer();
            }

        }
        return subStringSet;
    }
}
