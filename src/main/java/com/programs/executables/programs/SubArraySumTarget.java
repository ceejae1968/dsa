package com.programs.executables.programs;

import java.util.ArrayList;

public class SubArraySumTarget {
    public static void main(String args[]){
        int target = 26;
        int[] arr = new int[]{26,3,28,7};
        ArrayList<Integer> resp = new ArrayList<>();
        int start = 0;
        int end = 0;
        int sum = arr[start];
        while((end < arr.length && start < arr.length)){
            if(sum > target && start < arr.length-1){
                sum -= arr[start];
                start++;
            } else if(sum < target && end < arr.length -1){
                end++;
                sum += arr[end];
            } else if(sum == target){
                resp.add(start+1);
                resp.add(end+1);
//                return resp;
            } else {
                break;
            }
        }
        resp.add(-1);
//        return resp;

    }
}
