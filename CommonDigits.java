package algos;

import java.util.HashSet;
import java.util.Set;

class CommonDigits {
    public int[] common_digits(int[] nums) {
        // code here
        Set<Integer> intSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            String digitStream = String.valueOf(nums[i]);
            int lengthOfDigits = digitStream.length();
            for(int k = 1; k <= lengthOfDigits; k++){
                int val = Integer.parseInt(digitStream.substring(k-1, k));
                intSet.add(val);
            }
        }
        int[] intArr = intSet.stream().mapToInt(Integer::intValue).toArray();

        return intArr;
    }
}
