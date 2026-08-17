package com.programs.executables.programs;

public class TrappingRainwater {
    static void main(String[] args) {
        int[] arr = new int[]{3,0,1,0,4,0,2};
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        int leftMaxVal=0, rightMaxVal=0;
        for(int i = 0 ; i < arr.length; i++){
            leftMaxVal = Math.max(leftMaxVal, arr[i]);
            rightMaxVal = Math.max(rightMaxVal, arr[arr.length-1-i]);
            leftMax[i] = leftMaxVal;
            rightMax[arr.length-1-i] = rightMaxVal;
        }
        int rainwater = 0;
        for(int i = 0 ; i < arr.length; i++){
            int minH = Math.min(leftMax[i], rightMax[i]);
            rainwater += (minH - arr[i]);
        }
//        return rainwater;
        System.out.println(rainwater);
    }
}
