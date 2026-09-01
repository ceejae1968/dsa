package com.programs.executables.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSubarrayProduct {
    static void main(String[] args) {
        Map<Integer, List<Integer>> testCases = new HashMap<>();
        List<Integer> intList1 = List.of(-2, 6, -3, -10, 0, 2);
        List<Integer> intList2 = List.of(-1, -3, -10, 0, 6);
        List<Integer> intList3 = List.of(2, 3, 4);
        List<Integer> intList4 = List.of(4, 2, 3, -9, 3);
        List<Integer> intList5 = List.of(8, -1, 0, 5, -4, 7, 5);
        List<Integer> intList6 = List.of(-5);
        List<Integer> intList7 = List.of(-10, 0, -3);
        List<Integer> intList8 = List.of(0, 0, -10);
        testCases.put(180, intList1);
//        testCases.put(30, intList2);
//        testCases.put(24, intList3);
//        testCases.put(24, intList4);
//        testCases.put(35, intList5);
//        testCases.put(-5, intList6);
//        testCases.put(0, intList7);
//        testCases.put(0, intList8);
        testCases.forEach((e,k) -> {
            System.out.println(e == getMaximumSubarrayProductUsingDP(k.stream().mapToInt(Integer::intValue).toArray()));
            System.out.println(k);
        });
    }

    private static int getMaximumSubarrayProductUsingDP(int[] arr) {
        int currMax = arr[0];
        int currMin = arr[0];
        int maxProductSoFar = arr[0];
        for(int i = 1; i < arr.length; i++){
            int temp = Math.max(arr[i], Math.max(currMax * arr[i], currMin * arr[i]));
            currMin = Math.min(arr[i], Math.min(currMax * arr[i], currMin * arr[i]));
            currMax = temp;
            maxProductSoFar = Math.max(currMax, maxProductSoFar);
        }
        return maxProductSoFar;
    }
    private static int getMaximumSubarrayProduct(int[] arr) {
        if(arr.length < 2){
            return arr[0];
        }
        int k = 0;
        int max = 0;
        while(k < arr.length) {
            int i = k;
            int negatives = 0;
            int product = 1;
            while (i <= arr.length-1 &&arr[i] != 0) {
                if(arr[i] < 0){
                    negatives++;
                }
                i++;
            }
            if(negatives == 1){
                if(i-k == 1){
                    max = Math.max(arr[k], max);
                } else {
                    for (int j = k; j < i; j++) {
                        if (arr[j] > 0) {
                            product *= arr[j];
                        } else {
                            max = Math.max(product, max);
                            product = 1;
                        }
                    }
                    max = Math.max(max, product);
                }
            }
            else if(negatives%2 == 0) {
                if(i == k){
                    max = Math.max(arr[i], max);
                } else {
                    for (int j = k; j < i; j++) {
                        product *= arr[j];
                    }
                    max = Math.max(product, max);
                }
            } else {
                int left = k;
                int right = i-1;
                int leftProduct = 1;
                int rightProduct = 1;
                while(left < right && arr[left] > 0){
                    leftProduct *= arr[left];
                    left++;
                }
                if(right != left) {
                    leftProduct *= arr[left];
                }

                while(right > left && arr[right] > 0){
                    rightProduct *= arr[right];
                    right--;
                }
                if(right != left) {
                    rightProduct *= arr[right];
                }

                if (Math.abs(leftProduct) > Math.abs(rightProduct)) {
                    for (int j = left + 1; j < right; j++) {
                        leftProduct *= arr[j];
                    }
                    max = Math.max(leftProduct, max);
                } else {
                    for (int j = right - 1; j > left; j--) {
                        rightProduct *= arr[j];
                    }
                    max = Math.max(rightProduct, max);
                }
            }
            k = i+1;
        }
        return max;
    }
}
